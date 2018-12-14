package trie;

import java.util.TreeMap;

/**
 * leetcode 211. 添加与搜索单词 - 数据结构设计
 */
class WordDictionary {

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

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!current.next.containsKey(c)) {
                current.next.put(c, new Node());
            }
            current = current.next.get(c);
        }
        current.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(root, 0, word);
    }

    private boolean search(Node node, int wordIndex, String word) {
        if (wordIndex == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(wordIndex);
        if (c != '.') {
            Node n = node.next.get(c);
            if (n != null) {
                return search(n, wordIndex + 1, word);
            } else {
                return false;
            }
        } else {
            for (char ch : node.next.keySet()) {
                if (search(node.next.get(ch), wordIndex + 1, word)) {
                    return true;
                }
            }
            return false;
        }
    }
}

/**
 * Your trie.WordDictionary object will be instantiated and called as such:
 * trie.WordDictionary obj = new trie.WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
