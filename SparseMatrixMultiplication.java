/*
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
*/

public class Solution {
    // Time O(m * n)
    // Space O(m + n)
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        Map<Integer, Set<Integer>> AMap = new HashMap<>();
        Map<Integer, Set<Integer>> BMap = new HashMap<>();
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    Set<Integer> set = AMap.get(i);
                    if (set == null) {
                        set = new HashSet<Integer>();
                        AMap.put(i, set);
                    }
                    set.add(j);
                }
            }
        }
        for (int j = 0; j < B[0].length; j++) {
            for (int i = 0; i < B.length; i++) {
                if (B[i][j] != 0) {
                    Set<Integer> set = BMap.get(j);
                    if (set == null) {
                        set = new HashSet<Integer>();
                        BMap.put(j, set);
                    }
                    set.add(i);
                }
            }
        }
        
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                Set<Integer> ASet = AMap.get(i);
                Set<Integer> BSet = BMap.get(j);
                if (ASet != null && BSet != null) {
                    if (ASet.size() < BSet.size()) {
                        for (Integer index : ASet) {
                            if (BSet.contains(index)) {
                                result[i][j] += A[i][index] * B[index][j];
                            }
                        }
                    } else {
                        for (Integer index : BSet) {
                            if (ASet.contains(index)) {
                                result[i][j] += A[i][index] * B[index][j];
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}