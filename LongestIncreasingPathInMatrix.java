/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] cache = new int[matrix.length][matrix[0].length];
        int result = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int temp = help(matrix, i, j, cache);
                if (temp > result) {
                    result = temp;
                }
            }
        }
        
        return result;
    }
    
    private int help(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] > 0) {
            return cache[i][j];
        }
        
        int result = 0;
        for (int m = -1; m <= 1; m += 2) {
            if(m + i >= 0 && m + i < matrix.length && matrix[i][j] < matrix[i + m][j]) {
                int temp = help(matrix, m + i, j, cache);
                if (temp > result) {
                    result = temp;
                }
            }
            
            if (m + j >= 0 && m + j < matrix[0].length && matrix[i][j] < matrix[i][j + m]) {
                int temp = help(matrix, i, m + j, cache);
                if (temp > result) {
                    result = temp;
                }
            }
        }
        
        result++;
        
        cache[i][j] = result;
        return result;
    }
}