/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        dfs(root, result, "");
        
        return result;
    }
    
    private void dfs(TreeNode node, List<String> result, String path) {
        path += node.val;
        
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }
        path += "->";
        if (node.left != null) {
            dfs(node.left, result, path);
        }
        
        if (node.right != null) {
            dfs(node.right, result, path);
        }
    }
}

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        
        if (root.left == null && root.right == null) {
            result.add("" + root.val);
            return result;
        }
        
        
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        if (left != null) {
            for (String path : left) {
                path = root.val + "->" + path;
                result.add(path);
            }
        }
        if (right != null) {
            for (String path : right) {
                path = root.val + "->" + path;
                result.add(path);
            }
        }
        return result;
    }
}