/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, (long)Integer.MIN_VALUE - 1, root.val) && check(root.right, root.val, (long)Integer.MAX_VALUE + 1);
    }
    
    private boolean check(TreeNode root, long minB, long maxB) {
        if (root == null) {
            return true;
        }
        if(root.val >= maxB || root.val <= minB) {
            return false;
        }
        return check(root.left, minB, root.val) && check(root.right, root.val, maxB);
    }
}

public class Solution {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left) == false) {
            return false;
        }
        if (pre != null && root.val <= pre.val) {
            return false;
        }
        pre = root;
        if (isValidBST(root.right) == false) {
            return false;
        }
        return true;
    }
}