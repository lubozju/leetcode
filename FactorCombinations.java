/*
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
*/

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(n, new ArrayList<Integer>(), result);
        
        return result;
    }
    
    private void dfs(int n, List<Integer> path, List<List<Integer>> result) {
        int i = path.size() > 0 ? path.get(path.size() - 1) : 2;
        // exclude the original n
        if (path.size() > 0) {
            path.add(n);
            result.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
        }
        for (; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                path.add(i);
                dfs(n / i, path, result);
                path.remove(path.size() - 1);
            } 
        }
    }
}