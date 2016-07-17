/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class Solution {
    // Time O(n^2)
    // Space O(1)
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int k = 1;
        int xStart = 0;
        int xEnd = n - 1;
        int yStart = 0;
        int yEnd = n - 1;
        while (n > 0) {
            for (int i = yStart; i <= yEnd; i++) {
                result[xStart][i] = k++;
            } 
            xStart++;
            
            for (int i = xStart; i <= xEnd; i++) {
                result[i][yEnd] = k++;
            }
            yEnd--;
            
            for (int i = yEnd; i >= yStart; i--) {
                result[xEnd][i] = k++;
            }
            xEnd--;
            
            for (int i = xEnd; i >= xStart; i--) {
                result[i][yStart] = k++;
            }
            yStart++;

            n = n - 2;
        }
        return result;
    }
}