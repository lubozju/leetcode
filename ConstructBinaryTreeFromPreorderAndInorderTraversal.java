/*
Given preorder and inorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode help(int[] preorder, int sp, int ep, int[] inorder, int si, int ei) {
        if (sp > ep) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[sp]);
        int rIndex = findRoot(inorder, si, ei, preorder[sp]);
        root.left = help(preorder, sp + 1, sp + rIndex - si, inorder, si, rIndex - 1);
        root.right = help(preorder, sp + rIndex - si + 1, ep, inorder, rIndex + 1, ei);
        return root;
    }
    
    private int findRoot(int[] inorder, int si, int ei, int root) {
        for (int i = si; i <= ei; i++) {
            if (inorder[i] == root) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }
}