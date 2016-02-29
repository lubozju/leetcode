/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.


*/

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int result = Integer.MAX_VALUE;
        
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> level = triangle.get(i);
            for (int j = 0; j < level.size(); j++) {
                int temp = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    temp = triangle.get(i - 1).get(j - 1);
                }
                if (j < triangle.get(i - 1).size()) {
                    temp = Math.min(temp, triangle.get(i - 1).get(j));
                } 
                if (i == triangle.size() - 1) {
                    if (result > level.get(j) + temp) {
                        result = level.get(j) + temp;
                    }
                }
                level.set(j, level.get(j) + temp);
            }
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        return result;
    }
}