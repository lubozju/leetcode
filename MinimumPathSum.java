/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        
        int[] dp = new int[grid.length];
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[j][i];
                } else if (i == 0) {
                    dp[j] = dp[j - 1] + grid[j][i];
                } else if (j == 0) {
                    dp[j] = dp[j] + grid[j][i];
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[j][i];
                }
            }
        }
        
        return dp[dp.length - 1];
    }
}