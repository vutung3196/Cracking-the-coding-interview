package LeetCodeTopics.FavoredQuestions.TopKFrequentWords;

import java.util.*;

/**
 * <p>Given a non-empty list of words, return the k most frequent elements.
 * <p>
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency,
 * then the word with the lower alphabetical order comes first.
 * </p>
 * <p>Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2 </p>
 * <p>Output: ["i", "love"] </p>
 */
public class Solution {
    /**
     * Time complexity: O(n * log(n)) when using sort <br>
     * Space complexity: O(n)
     *
     * @param words
     * @param k
     * @return list of String
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordToCount = new HashMap();
        for (String word : words) {
            wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
        }

        List<String> candidates = new ArrayList(wordToCount.keySet());
        candidates.sort((w1, w2) -> wordToCount.get(w1).equals(wordToCount.get(w2)) ?
                w1.compareTo(w2) : wordToCount.get(w2) - wordToCount.get(w1));
        return candidates.subList(0, k);
    }

    /**
     * Time complexity: O(n * log(k)) when using sort <br>
     * Space complexity: O(n)
     *
     * @param words
     * @param k
     * @return list of String
     */
    public List<String> topKFrequentUsingHeap(String[] words, int k) {
        Map<String, Integer> wordToCount = new HashMap<>();
        for (String word : words) {
            wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> wordToCount.get(w1).equals(wordToCount.get(w2)) ?
                w1.compareTo(w2) : wordToCount.get(w2) - wordToCount.get(w1));

        for (String word : wordToCount.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
}
