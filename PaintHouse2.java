/*
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?
*/

public class Solution {
    // Time O(nk)
    // Space O(1)
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if (n == 0) {
            return 0;
        }
        int k = costs[0].length;
        int min1Val = 0;
        int min1Col = 0;
        int min2Val = 0;
        for (int i = 0; i < n; i++) {
            int newMin1Val = Integer.MAX_VALUE;
            int newMin1Col = 0;
            int newMin2Val = newMin1Val;
            for (int j = 0; j < k; j++) {
                int preMin = j == min1Col ? min2Val : min1Val;
                int dp = costs[i][j] + preMin;
                if (dp < newMin1Val) {
                    newMin2Val = newMin1Val;
                    newMin1Val = dp;
                    newMin1Col = j;
                } else if (dp < newMin2Val) {
                    newMin2Val = dp;
                }
            }
            min1Col = newMin1Col;
            min1Val = newMin1Val;
            min2Val = newMin2Val;
        }
        return min1Val;
    }
}