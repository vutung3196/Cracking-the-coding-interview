package neetcode150.slidingwindows.buyandsellstock;

public class Solution {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        var maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }
}
