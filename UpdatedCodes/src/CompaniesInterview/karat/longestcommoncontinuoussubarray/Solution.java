package CompaniesInterview.karat.longestcommoncontinuoussubarray;

import java.util.ArrayList;
import java.util.*;

public class Solution {
    public static void main(String[] argv) {
        System.out.println("Hello, world!");
        System.out.println("This is a fully functioning Java environment.");
        String[] user1 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
        String[] user2 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
        var result = longestCommonContinuousSubArray(Arrays.asList(user1), Arrays.asList(user2));
        for (var element : result) {
            System.out.println(element);
        }
        // output: pink, register and orange
    }

    public static List<String> longestCommonContinuousSubArray(List<String> user1, List<String> user2) {
        var result = new ArrayList<String>();
        if (user1 == null || user2 == null || user1.size() == 0 || user2.size() == 0) return result;
        int max = -1;
        var memo = new int[user1.size() + 1][user2.size() + 1];
        for (int i = user1.size() - 1; i >= 0; i--) {
            for (int j = user2.size() - 1; j >= 0; j--) {
                if (Objects.equals(user1.get(i), user2.get(j))) {
                    memo[i][j] = 1 + memo[i+1][j+1];
                    if (memo[i][j] > max) {
                        max = memo[i][j];
                        result = new ArrayList<>(user1.subList(i, i + max));
                    }
                }
            }
        }

        return result;
    }
}
