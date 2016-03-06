/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police
*/

public class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        
        int[][] help = new int[length][length];
        
        for (int i = 0; i< length; i++) {
            help[i][i] = nums[i];
        }
        
        for (int d = 1; d < length; d++) {
            for (int start = 0; start + d < length; start++) {
                int end = start + d;
                help[start][end] = 0;
                for (int i = start; i <= end; i++) {
                    int temp = 0;
                    if (i - 1 >= start) {
                        temp += help[start][i - 1];
                    }
                    if (i + 1 <= end) {
                        temp += help[i + 1][end];
                    }
                    if (temp > help[start][end]) {
                        help[start][end] = temp;
                    }
                }
            }
        }
        
        return help[0][length - 1];
    }
}

public class Solution {
    public int rob(int[] nums) {
        int result = 0;
        int[] dp = new int[nums.length];
        
        if (nums.length > 0) {
            dp[0] = nums[0];
            result = Math.max(result, dp[0]);
        }
        if (nums.length > 1) {
            dp[1] = nums[1];
            result = Math.max(result, dp[1]);
        }
        
        for (int i = 2; i < nums.length; i++) {
            dp[i] = nums[i] + ((i - 3 >= 0) ? Math.max(dp[i - 2], dp[i - 3]) : dp[i - 2]); 
            result = Math.max(result, dp[i]);
        }
        
        return result;
    }
}

public class Solution {
    public int rob(int[] nums) {
        int rob = 0;
        int notRob = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int temp = rob;
            rob = nums[i] + notRob;
            notRob = Math.max(notRob, temp);
        }
        return Math.max(rob, notRob);
    }
}