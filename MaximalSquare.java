/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.

*/

public class Solution {
    public int maximalSquare(char[][] matrix) {
         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
         }

        int result = 0;
        int[][] l = new int[matrix.length + 1][matrix[0].length + 1];
        
        // l[i][j] represents the length of the largest square ended at (i - 1, j - 1)
        for (int i = 1; i < l.length; i++) {
            for (int j = 1; j < l[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    l[i][j] = Math.min(Math.min(l[i - 1][j - 1], l[i][j - 1]), l[i - 1][j]) + 1;
                    result = Math.max(result, l[i][j]);
                }
            }
        }
        
        return result * result;
    }
}

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] dp = new int[matrix.length + 1];
        
        int result = 0;
        int pre = 0; // pre = dp[i - 1][j - 1]
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 1; i < matrix.length + 1; i++) {
                int temp = dp[i];
                if (matrix[i - 1][j] == '1') {
                    dp[i] = Math.min(Math.min(dp[i - 1], pre), dp[i]) + 1;
                    if (result < dp[i]) {
                        result = dp[i];
                    }
                }
                // remember to update dp even if matrix[i - 1][j] == '0'
                else {
                    dp[i] = 0;
                }
                pre = temp;
            }
        }
        
        return result * result;
    }
}