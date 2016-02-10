/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

public class Solution {
    public int numTrees(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][i] = 1;
        }
        for (int d = 1; d <= n - 1; d++) {
            for (int min = 1; min <= n - d; min++) {
                int max = min + d;
                dp[min][max] = 0;
                for (int i = min + 1; i <= max - 1; i++) {
                    dp[min][max] += dp[min][i - 1] * dp[i + 1][max];
                }
                dp[min][max] += dp[min + 1][max] + dp[min][max - 1];
                
            }
        }
        return dp[1][n];
    }
}