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
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) + countNodes(root.right);
        } 
        return countNodes(root.left) + (1 << (leftHeight - 1));
        
    }
    private int getHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
}

public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        int LeftHeight = getHeight(root.left);
        while (root != null) {
            int rightHeight = getHeight(root.right);
            if (LeftHeight == rightHeight) {
                result += (1 << LeftHeight);
                root = root.right;
            } else {
                result += (1 << (LeftHeight - 1));
                root = root.left;
            }
            LeftHeight--;
        }
        return result;
    }
    private int getHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
}