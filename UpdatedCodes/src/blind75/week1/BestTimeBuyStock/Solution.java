package blind75.week1.BestTimeBuyStock;

public class Solution {
    //    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    //    You want to maximize your profit by choosing a single day to buy one stock and choosing
    //    a different day in the future to sell that stock.
    //    Return the maximum profit you can achieve from this transaction.
    //    If you cannot achieve any profit, return 0.
    private static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        // idea: finding min price first
        // calculate the maximum profit based on the min price
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        var input = new int[] {7,1,5,3,6,4};
        System.out.println(maxProfit(input));
    }
}
