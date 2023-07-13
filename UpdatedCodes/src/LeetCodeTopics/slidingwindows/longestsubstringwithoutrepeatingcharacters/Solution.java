package LeetCodeTopics.slidingwindows.longestsubstringwithoutrepeatingcharacters;

public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int i = 0, j = 0;
        int N = s.length();
        char[] cnt = new char[128];
        for (j = 0; j < N; j++) {
            cnt[s.charAt(j)]++;
            while (cnt[s.charAt(j)] > 1) {
                cnt[s.charAt(i)]--;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
