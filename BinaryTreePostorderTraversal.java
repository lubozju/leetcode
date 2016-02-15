/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        Deque<Boolean> visited = new LinkedList<Boolean>();
        stack.push(root);
        visited.push(false);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            Boolean v = visited.pop();
            if (!v) {
                stack.push(node);
                visited.push(!v);
                if (node.right != null) {
                    stack.push(node.right);
                    visited.push(false);
                }
                if (node.left != null) {
                    stack.push(node.left);
                    visited.push(false);
                }
            } else {
                result.add(node.val);
            }
        }
        return result;
    }
    
}