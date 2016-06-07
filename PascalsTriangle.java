/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    // Time: O(n^2)
    // Space: O(1)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                List<Integer> row = new ArrayList<Integer>();
                row.add(1);
                result.add(row);
            } else {
                List<Integer> lastRow = result.get(i - 1);
                List<Integer> row = new ArrayList<Integer>();
                for (int j = 0; j < lastRow.size(); j++) {
                    if (j > 0) {
                        row.add(lastRow.get(j - 1) + lastRow.get(j));
                    } else {
                        row.add(lastRow.get(j));
                    }
                }
                row.add(1);
                result.add(row);
            }
        }
        return result;
    }
}

public class Solution {
    // Time: O(n^2)
    // Space: O(1)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }
        if (numRows == 1) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            result.add(row);
            return result;
        }
        
        result = generate(numRows - 1);
        
        List<Integer> lastRow = result.get(result.size() - 1);
        List<Integer> row = new ArrayList<Integer>();
        for (int i = 0; i < lastRow.size(); i++) {
            if (i == 0) {
                row.add(lastRow.get(i));
            } else {
                row.add(lastRow.get(i - 1) + lastRow.get(i));
            }
        }
        row.add(1);
        result.add(row);
        
        return result;
    }
}