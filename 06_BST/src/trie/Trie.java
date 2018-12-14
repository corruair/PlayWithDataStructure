package trie;

import java.util.TreeMap;

/**
 * 字典树
 */
public class Trie {

    private class Node {
        private boolean isWord;
        TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private int size;
    private Node root;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加单词
     *
     * @param word
     */
    public void add(String word) {
//        Node current = root;
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            if (!current.next.containsKey(c)) {
//                current.next.put(c, new Node());
//            }
//            current = current.next.get(c);
//        }
//        current.isWord = true;
//        size++;

        add(root, 0, word);
    }

    /**
     * 递归实现Trie的添加操作
     *
     * @param node
     * @param wordIndex
     * @param word
     */
    private void add(Node node, int wordIndex, String word) {
        if (wordIndex == word.length()) {
            size++;
            return;
        }
        char c = word.charAt(wordIndex);
        if (!node.next.containsKey(c)) {
            node.next.put(c, new Node());
        }
        if (wordIndex == word.length() - 1) {
            node.next.get(c).isWord = true;
        }
        add(node.next.get(c), ++wordIndex, word);
    }

    /**
     * 是否包含特定单词
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {
        return contains(root, 0, word);
    }

    private boolean contains(Node node, int wordIndex, String word) {
        if (node.next == null || wordIndex == word.length()) {
            return false;
        }
        char c = word.charAt(wordIndex);
        if (node.next.containsKey(c)) {
            if (wordIndex == word.length() - 1 && node.next.get(c).isWord) {
                return true;
            } else {
                return contains(node.next.get(c), ++wordIndex, word);
            }
        }
        return false;
    }

    /**
     * 是否包含前缀
     *
     * @param prefix
     * @return
     */
    public boolean isPreFix(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (current.next != null && current.next.containsKey(c)) {
                current = current.next.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
}
