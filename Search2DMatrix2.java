/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length - 1;
        int y = x >= 0 ? matrix[0].length - 1 : 0;
        return help(matrix, 0, 0, x, y, target);
    }
    
    private boolean help(int[][] matrix, int x0, int y0, int x1, int y1, int target) {
        //check if the matrix is valid
        if (x0 > x1 || y0 > y1) {
            return false;
        }
        
        int xm = x0 + (x1 - x0) / 2;
        int ym = y0 + (y1 - y0) / 2;
        
        if (target == matrix[xm][ym]) {
            return true;
        }
        boolean result = false;
        if (target < matrix[xm][ym]) {
            if (target >= matrix[x0][ym]) {
                result = result || help(matrix, x0, ym, xm - 1, y1, target);
            }
            if (target >= matrix[xm][y0]) {
                result = result || help(matrix, xm, y0, x1, ym - 1, target);
            }
            result = result || help(matrix, x0, y0, xm - 1, ym - 1, target);
        } else {
            if (target <= matrix[xm][y1]) {
                result = result || help(matrix, x0, ym + 1, xm, y1, target);
            }
            if (target <= matrix[x1][ym]) {
                result = result || help(matrix, xm + 1, y0, x1, ym, target);
            }
            result = result || help(matrix, xm + 1, ym + 1, x1, y1, target);
        }
        
        return result;
    }
}

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return help(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }
    
    private boolean help(int[][] matrix, int topx, int topy, int botx, int boty, int target) {
            if (topx > botx || topy > boty) {
                return false;
            }
            if (target < matrix[topx][topy] || target > matrix[botx][boty]) {
                return false;
            }
            int midx = topx + (botx - topx) / 2;
            int midy = topy + (boty - topy) / 2;
            if (matrix[midx][midy] == target) {
                return true;
            }
            if (matrix[midx][midy] < target) {
                return help(matrix, topx, midy + 1, midx, boty, target) || help(matrix, midx + 1, topy, botx, midy, target) || help(matrix, midx + 1, midy + 1, botx, boty, target);
            }
            return help(matrix, topx, midy, midx - 1, boty, target) || help(matrix, midx, topy, botx, midy - 1, target) || help(matrix, topx, topy, midx - 1, midy - 1, target);
    }
}

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length - 1;
        
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
}