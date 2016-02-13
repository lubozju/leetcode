/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.add(root);
            depth++;
        }
        Queue<TreeNode> tempQueue = new LinkedList<TreeNode>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                tempQueue.add(node.left);
            }
            if (node.right != null) {
                tempQueue.add(node.right);
            }
            if (queue.isEmpty()) {
                queue = tempQueue;
                tempQueue = new LinkedList<TreeNode>();
                if (!queue.isEmpty()) {
                    depth++;
                }
            }
        }
        return depth;
    }
}
