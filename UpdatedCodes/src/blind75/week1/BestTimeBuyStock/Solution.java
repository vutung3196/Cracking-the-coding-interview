package blind75.week1.BestTimeBuyStock;

public class Solution {
    //    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    //    You want to maximize your profit by choosing a single day to buy one stock and choosing
    //    a different day in the future to sell that stock.
    //    Return the maximum profit you can achieve from this transaction.
    //    If you cannot achieve any profit, return 0.
    private static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        // starting our while loop and running until
        // right pointer is less than the length of the array
        while (right < prices.length) {
            var currentProfit = prices[right] - prices[left];
            if (prices[left] < prices[right]) {
                maxProfit = Math.max(currentProfit, maxProfit);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        var input = new int[] {7,1,5,3,6,4};
        System.out.println(maxProfit(input));
    }
}
