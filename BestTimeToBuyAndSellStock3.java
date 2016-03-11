/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        
        int max = 0;
        int tempMax = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 1; i--) {
            tempMax = Math.max(tempMax, prices[i]);
            if (prices[i] < tempMax) {
                max = Math.max(max, tempMax - prices[i] + dp[i - 1]);
            }
        }
        return Math.max(max, dp[dp.length - 1]);
    }
}