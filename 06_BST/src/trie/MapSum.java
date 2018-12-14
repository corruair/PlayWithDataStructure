package trie;

import java.util.TreeMap;

/**
 * leetcode 677. 键值映射
 */
public class MapSum {
    private class Node {
        private int value;
        TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node current = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!current.next.containsKey(c)) {
                current.next.put(c, new Node());
            }
            current = current.next.get(c);
        }
        current.value = val;
    }

    public int sum(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            Node tempNode = current.next.get(c);
            if (null == tempNode) {
                return 0;
            } else {
                current = tempNode;
            }
        }

        return sum(current);

    }

    private int sum(Node node) {
        int res = node.value;
        for (char c : node.next.keySet()) {
            res = res + sum(node.next.get(c));
        }
        return res;
    }
}
