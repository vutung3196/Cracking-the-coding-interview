package CompaniesInterview.affirm;

import java.util.*;

public class FindSubStringTrieSolution {
    public static void main(String[] args) {

    }


    public String[] shortestSubstrings(String[] names) {
        Trie trie = new Trie();

        // Insert all substrings of all names
        for (String name : names) {
            for (int length = 1; length <= name.length(); length++) {
                for (int start = 0; start <= name.length() - length; start++) {
                    String substring = name.substring(start, start + length);
                    trie.insert(substring, name);
                }
            }
        }

        // Find shortest unique substring for each name
        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            result[i] = trie.findShortestUniqueSubstring(names[i], names);
        }

        return result;
    }

    static class TrieNode {
        // Map to store child nodes
        Map<Character, TrieNode> children = new HashMap<>();

        // Set to track which names contain this node's path
        Set<String> namesContaining = new HashSet<>();

        // Flag to mark end of a word
        boolean isEndOfWord = false;
    }

    /**
     * Trie data structure for efficient substring tracking
     */
    static class Trie {
        TrieNode root = new TrieNode();

        /**
         * Insert a string into the trie
         * @param word String to insert
         * @param originalName Name of the string for tracking
         */
        void insert(String word, String originalName) {
            TrieNode current = root;

            // Insert each character of the word
            for (char ch : word.toCharArray()) {
                current = current.children.computeIfAbsent(ch, k -> new TrieNode());
                current.namesContaining.add(originalName);
            }

            current.isEndOfWord = true;
        }

        /**
         * Find the shortest unique substring for a given name
         * @param name Name to find unique substring for
         * @return Shortest unique substring
         */
        String findShortestUniqueSubstring(String name, String[] names) {
            List<String> uniqueSubstrings = new ArrayList<>();
            for (int length = 1; length <= name.length(); length++) {
                for (int start = 0; start <= name.length() - length; start++) {
                    String substring = name.substring(start, start + length);
                    if (isUniqueSubstring(substring, names)) {
                        uniqueSubstrings.add(substring);
                    }
                }
            }

            if (uniqueSubstrings.isEmpty()) return "";
            List<String> shortestStrings = new ArrayList<String>();
            int minLength = Integer.MAX_VALUE;
            for (String s : uniqueSubstrings) {
                if (s.length() < minLength) {
                    minLength = s.length();
                }
            }

            for (String s : uniqueSubstrings) {
                if (s.length() == minLength) {
                    shortestStrings.add(s);
                }
            }

            return Collections.min(shortestStrings);
        }

        /**
         * Check if a substring is unique across all names
         * @param substring Substring to check
         * @return True if substring is unique, false otherwise
         */
        boolean isUniqueSubstring(String substring, String[] allNames) {
            // Count occurrences of the substring across all names
            int count = 0;
            for (String name : allNames) {
                if (name.contains(substring)) {
                    count++;
                }
                // Early exit if more than one occurrence
                if (count > 1) return false;
            }

            // Exactly one occurrence is unique
            return count == 1;
        }
    }
}
