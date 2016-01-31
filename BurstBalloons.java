/*
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
*/

public class Solution {
    public int maxCoins(int[] nums) {
        int[] pNums = new int[nums.length + 2];
        
        int count = 1;
        pNums[0] = 1;
        for (int num : nums) {
            if (num > 0) {
                pNums[count] = num;
                count++;
            }
        }
        pNums[count] = 1;
        count++;
        
        // dp[i][j] is the result of nums[i + 1][j - 1], i is the dummy head and j is the dummy tail
        int[][] dp = new int[count][count];
        
        // left + dis = right
        for (int dis = 2; dis < count; dis++) {
            for (int left = 0; left < count - dis; left++) {
                int right = left + dis;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], pNums[left] * pNums[i] * pNums[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        
        return dp[0][count - 1];
    }
}