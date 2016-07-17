/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

public class Solution {
	// Time O(m * n) 
	// Space O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new ArrayList<Integer>();
        }
        int n = matrix[0].length;
        return help(matrix, 0, 0, m, n);
    }
    private List<Integer> help(int[][] matrix, int x, int y, int m, int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (m == 0 || n == 0) {
            return result;
        }
        if (m == 1) {
            for (int i = y; i < y + n; i++) {
                result.add(matrix[x][i]);
            }
            return result;
        }
        
        if (n == 1) {
            for (int i = x; i < x + m; i++) {
                result.add(matrix[i][y]);
            }
            return result;
        }
        
        for (int i = y; i < y + n; i++) {
            result.add(matrix[x][i]);
        }
        
        for (int i = x + 1; i < x + m; i++) {
            result.add(matrix[i][y + n - 1]);
        }
        
        for (int i = y + n - 2; i >= y; i--) {
            result.add(matrix[x + m - 1][i]);
        }
        
        for (int i = x + m - 2; i >= x + 1; i--) {
            result.add(matrix[i][y]);
        }
        
        List<Integer> sub = help(matrix, x + 1, y + 1, m - 2, n - 2);
        result.addAll(sub);
        return result;
    }
}

public class Solution {
    // Time O(m * n)
    // Space O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new ArrayList<Integer>();
        }
        
        List<Integer> result = new ArrayList<Integer>();
        int n = matrix[0].length;
        int xStartBound = 0;
        int xEndBound = m - 1;
        int yStartBound = 0;
        int yEndBound = n - 1;
        
        while (xStartBound <= xEndBound && yStartBound <= yEndBound) {
            
            for (int i = yStartBound; i <= yEndBound; i++) {
                result.add(matrix[xStartBound][i]);
            }
            xStartBound++;
            
            for (int i = xStartBound; i <= xEndBound; i++) {
                result.add(matrix[i][yEndBound]);
            }
            yEndBound--;
            
            // check if still valid
            if (xStartBound <= xEndBound) {
                for (int i = yEndBound; i >= yStartBound; i--) {
                    result.add(matrix[xEndBound][i]);
                }
                xEndBound--;
            }
        
            // check if still valid
            if (yStartBound <= yEndBound) {
                for (int i = xEndBound; i >= xStartBound; i--) {
                    result.add(matrix[i][yStartBound]);
                }
                yStartBound++;
            }
        }
        return result;
    }
}