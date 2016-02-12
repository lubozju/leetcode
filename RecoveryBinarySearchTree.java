/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        pre = null;
        TreeNode bigNode = findBig(root);
        pre = null;
        TreeNode smallNode = findSmall(root);
        if (bigNode != null && smallNode != null) {
            int temp = bigNode.val;
            bigNode.val = smallNode.val;
            smallNode.val = temp;
        }
    }
    
    private TreeNode findBig(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode bigNode = findBig(root.left);
        if (bigNode != null) {
            return bigNode;
        }
        if (pre != null && root.val < pre.val) {
            return pre;
        }
        pre = root;
        return findBig(root.right);
    }
    
    private TreeNode findSmall(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode smallNode = findSmall(root.right);
        if (smallNode != null) {
            return smallNode;
        }
        if (pre != null && root.val > pre.val) {
            return pre;
        }
        pre = root;
        return findSmall(root.left);
    }
}