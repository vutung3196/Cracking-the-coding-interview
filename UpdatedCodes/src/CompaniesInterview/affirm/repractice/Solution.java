package CompaniesInterview.affirm.repractice;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] input = {"fhi","ct","s","o","o"};
        var result = new Solution().shortestSubstrings(input);
        for (var str : result) {
            System.out.println(str);
        }
    }

    /**
     * Find shortest unique substrings for all names
     * Time Complexity: O(nm²), where n is number of names, m is name length
     * Space Complexity: O(nm)
     *
     * @param names List of input strings
     * @return Map of names to their shortest unique substrings
     */
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
            var curr = names[i];
            for (int j = 0; j < names.length; j++) {
                if (i == j) continue;
                var other = names[j];
                if (other.equals(curr)) {
                    result[i] = "";
                }
            }
        }

        // process the ignored index
        for (int i = 0; i < names.length; i++) {
            // index i, then we check if we have another name that has the same string
            // if we have, then we ignore it
            // if we don't have, then we return the string
            if (result[i] == null) {
                result[i] = trie.findShortestUniqueSubstring(names[i]);
            }
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
        String findShortestUniqueSubstring(String name) {
            List<String> uniqueSubstrings = new ArrayList<>();
            for (int length = 1; length <= name.length(); length++) {
                for (int start = 0; start <= name.length() - length; start++) {
                    String substring = name.substring(start, start + length);
                    if (isUniqueSubstring(substring)) {
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
        boolean isUniqueSubstring(String substring) {
            TrieNode current = root;

            // Traverse to the end of the substring in the trie
            for (char ch : substring.toCharArray()) {
                if (!current.children.containsKey(ch)) {
                    return false;
                }
                current = current.children.get(ch);
            }

            // Check if the substring appears in only one name
            return current.namesContaining.size() == 1;
        }
    }
}