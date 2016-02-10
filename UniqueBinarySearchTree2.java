/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return help(1, n, new HashMap<List<Integer>, List<TreeNode>>());
    }
    
    private List<TreeNode> help(int min, int max, Map<List<Integer>, List<TreeNode>> cache) {
        List<Integer> key = new ArrayList<Integer>();
        key.add(min);
        key.add(max);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        
        if (min > max) {
            return new ArrayList<TreeNode>();
        }
        if (min == max) {
            List<TreeNode> result = new ArrayList<TreeNode>();
            result.add(new TreeNode(min));
            return result;
        }
        
        List<TreeNode> result = new ArrayList<TreeNode>();
        for (int i = min; i <= max; i++) {
            List<TreeNode> lefts = help(min, i - 1, cache);
            List<TreeNode> rights = help(i + 1, max, cache);
            if (lefts.size() == 0) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.right = right;
                    result.add(root);
                }
            } else if (rights.size() == 0) {
                for (TreeNode left : lefts) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    result.add(root);
                }
            } else {
                for (TreeNode left : lefts) {
                    for (TreeNode right : rights) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }
            }
        }
        
        cache.put(key, result);
        return result;
    }
}