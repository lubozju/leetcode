/*
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
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
    private class Result {
        int pathSum;
        int path;
        
        Result(int pathSum, int path) {
            this.pathSum = pathSum;
            this.path = path;
        }
    }
    public int maxPathSum(TreeNode root) {
        Result result = help(root);
        return result.pathSum;
    }
    
    private Result help(TreeNode root) {
        if (root == null) {
            return new Result(Integer.MIN_VALUE, 0);
        }

        Result lResult = help(root.left);
        Result rResult = help(root.right);
        
        int temp = root.val;
        int path = temp + Math.max(0, Math.max(lResult.path, rResult.path));
        
        if (lResult.path > 0) {
            temp += lResult.path;
        }
        if (rResult.path > 0) {
            temp += rResult.path;
        }
        int pathSum = Math.max(temp, Math.max(lResult.pathSum, rResult.pathSum));
        
        return new Result(pathSum, path);
    }

}