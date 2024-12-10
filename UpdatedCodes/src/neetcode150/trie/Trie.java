package neetcode150.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    // Each node
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }

        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }

        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }

    private class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isEndOfWord;

        public TrieNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert words into the trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");

        // Search for words in the trie
        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("app")); // true
        System.out.println(trie.startsWith("appl")); // true
    }
}
