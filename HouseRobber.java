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