/*
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.
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
 // Time O(h)
 // Space O(1)
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p == null) {
            return null;
        }
        if (p.right != null) {
            TreeNode curNode = p.right;
            while (curNode.left != null) {
                curNode = curNode.left;
            }
            return curNode;
        }
        TreeNode candidate = null;
        TreeNode curNode = root;
        while (curNode != p) {
            // only the curNode whose val is greater can be candidate
            if (curNode.val > p.val) {
                candidate = curNode;
                curNode = curNode.left;
            } else {
                curNode = curNode.right;
            }
        }
        return candidate;
    }
}

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            if (left == null) {
                return root;
            }
            return left;
        }
    }
}