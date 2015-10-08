/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

*/

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // 0 is dummy start node
        dfs(0, k, n, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(int curInt, int k, int residue, ArrayList<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            if (residue == 0) {
                List<Integer> listClone = (List<Integer>)list.clone();
                result.add(listClone);
            }
            return;
        }
        for (int i = curInt + 1; i <= 9 && i <= residue; i++) {
            list.add(i);
            dfs(i, k, residue - i, list, result);
            list.remove(list.size() - 1);
        }
    }
}