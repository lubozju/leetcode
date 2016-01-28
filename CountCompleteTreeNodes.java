/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = countLevel(root);
        if (level == 0) {
            return 1;
        }
        
        if (countLevel(root.right) == level - 1) {
            return countNodes(root.right) + (1 << level);
        } else {
            return countNodes(root.left) + (1 << (level - 1));
        }
    }
    
    // private boolean isFull(TreeNode root, int level) {
    //     while (root != null) {
    //         root = root.right;
    //         level--;
    //     }
    //     return level == -1;
    // }
    
    // left path
    private int countLevel(TreeNode root) {
        int count = -1;
        while (root != null) {
            root = root.left;
            count++;
        }
        return count;
    }
}