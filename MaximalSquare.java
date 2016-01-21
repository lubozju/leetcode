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