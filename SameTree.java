/*
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stackP = new Stack<TreeNode>();
        Stack<TreeNode> stackQ = new Stack<TreeNode>();
        
        if (p != null) {
            stackP.push(p);
        }
        if (q != null) {
            stackQ.push(q);
        }
        
        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode nodeP = stackP.pop();
            TreeNode nodeQ = stackQ.pop();
            while (nodeP != null && nodeQ != null) {
                if (nodeP.val != nodeQ.val) {
                    return false;
                }
                if (nodeP.right != null) {
                    stackP.push(nodeP.right);
                }
                if (nodeQ.right != null) {
                    stackQ.push(nodeQ.right);
                }
                if (stackP.size() != stackQ.size()) {
                    return false;
                }
                nodeP = nodeP.left;
                nodeQ = nodeQ.left;
            }
            if (nodeP != nodeQ) {
                return false;
            }
        }
        return stackP.size() == stackQ.size();
    }
}