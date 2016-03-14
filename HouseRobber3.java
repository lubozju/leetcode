/*
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.
Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.

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
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> cache = new HashMap<TreeNode, Integer>();
        return help(root, cache);
    }
    
    private int help(TreeNode root, Map<TreeNode, Integer> cache) {
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
         
        if (root == null) {
            return 0;
        }
        int result = root.val;
        if (root.left != null) {
            result += help(root.left.left, cache);
            result += help(root.left.right, cache);
        }
        
        if (root.right != null) {
            result += help(root.right.left, cache);
            result += help(root.right.right, cache);
        }
        
        int temp = 0;
        if (root.left != null) {
            temp += root.left.val;
            temp += help(root.right, cache);
            if (root.left.left != null) {
                temp += help(root.left.left.left, cache);
                temp += help(root.left.left.right, cache);
            }
            if (root.left.right != null) {
                temp += help(root.left.right.left, cache);
                temp += help(root.left.right.right, cache);
            }
        }
        result = Math.max(result, temp);
        
        temp = 0;
        if (root.right != null) {
            temp += root.right.val;
            temp += help(root.left, cache);
            if (root.right.left != null) {
                temp += help(root.right.left.left, cache);
                temp += help(root.right.left.right, cache);
            }
            if (root.right.right != null) {
                temp += help(root.right.right.left, cache);
                temp += help(root.right.right.right, cache);
            }
        }
        
        result = Math.max(result, temp);
        cache.put(root, result);
        
        return result;
        
    }
}