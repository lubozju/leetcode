/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] help = new int[prices.length];
        
        help[help.length - 1] = 0;
        int max = 0;
        for (int i = help.length - 2; i >= 0; i--) {
            int k = i;
            while (k < prices.length) {
                if (prices[i] <= prices[k]) {
                    int cur = prices[k] - prices[i];
                    if (k + 2 < help.length) {
                        cur += help[k + 2];
                    }
                    if (cur > max) {
                        max = cur;
                    }   
                }
                k++;
            }
            help[i] = max;
        } 
        
        return help[0];
    }
}

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        
        for (int i = 1; i < dp.length; i++) {
            int k = i;
            dp[i] = dp[i - 1];
            while (k >= 0) {
                if (prices[i] > prices[k]) {
                    int temp = prices[i] - prices[k];
                    if (k - 2 >= 0) {
                        temp += dp[k - 2];
                    }
                    dp[i] = Math.max(dp[i], temp);
                }
                k--;
            }
        }
        
        return dp[prices.length - 1];
    }
}