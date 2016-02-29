/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
*/

public class Solution {
    public int uniquePaths(int m, int n) {
        int max = Math.max(m, n);
        int min = Math.min(m, n);
        int[] dp = new int[min];
        dp[0] = 1;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < min; j++) {
                if (j - 1 >= 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        
        return dp[min - 1];
    }
}