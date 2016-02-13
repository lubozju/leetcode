/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }
}

public class Solution {
    public int minDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.add(root);
            depth++;
        }
        Queue<TreeNode> tempQueue = new LinkedList<TreeNode>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                tempQueue.add(node.left);
            }
            if (node.right != null) {
                tempQueue.add(node.right);
            }
            if (queue.isEmpty()) {
                queue = tempQueue;
                tempQueue = new LinkedList<TreeNode>();
                depth++;
            }
        }
        return depth;
    }
}