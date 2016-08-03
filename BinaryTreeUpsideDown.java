/*
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  
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
    // Time O(n)
    // Space O(1)
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left);
        if (newRoot == null) {
            return root;
        }
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}

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
    // Time O(n)
    // Space O(n)
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        // need to check is stack is empty before pop
        root = stack.isEmpty() ? root : stack.pop();
        TreeNode cur = root;
        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            cur.left = right.right;
            cur.right = right;
            right.left = null;
            right.right = null;
            cur = cur.right;
        }
        
        return root;
    }


public class Solution {
    // Time O(n)
    // Space O(1)
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode right = null;
        while (root != null) {
            TreeNode next = root.left;
            root.left = right;
            right = root.right;
            root.right = pre;
            pre = root;
            root = next;
        }
        return pre;
    }
}
}