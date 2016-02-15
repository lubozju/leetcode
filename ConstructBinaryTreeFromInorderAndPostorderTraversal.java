/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            cache.put(inorder[i], i);
        }
        return help(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, cache);
    }
    
    private TreeNode help(int[] inorder, int si, int ei, int[] postorder, int sp, int ep, Map<Integer, Integer> cache) {
        if (sp > ep) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[ep]);
        int rIndex = cache.get(postorder[ep]);
        root.left = help(inorder, si, rIndex - 1, postorder, sp, sp + rIndex - si - 1, cache);
        root.right = help(inorder, rIndex + 1, ei, postorder, sp + rIndex - si, ep - 1, cache);
        
        return root;
    }
}