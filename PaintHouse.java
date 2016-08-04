/*
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.
*/

public class Solution {
	// Time O(n)
	// Space O(1)
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int dpRed = costs[0][0];
        int dpBlue = costs[0][1];
        int dpGreen = costs[0][2];
        
        for (int i = 1; i < costs.length; i++) {
            int oldRed = dpRed;
            int oldBlue = dpBlue;
            int oldGreen = dpGreen;
            dpRed = Math.min(oldBlue, oldGreen) + costs[i][0];
            dpBlue = Math.min(oldRed, oldGreen) + costs[i][1];
            dpGreen = Math.min(oldRed, oldBlue) + costs[i][2];
        }
        
        return Math.min(dpGreen, Math.min(dpRed, dpBlue));
    }
}