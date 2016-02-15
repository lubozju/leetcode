/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        dfs(root, new String(), result);
        return result;
    }
    
    private void dfs(TreeNode root, String path, List<String> result) {
        if (root == null) {
            return;
        }
        path = path + root.val;
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        
        path = path + "->";
        if (root.left != null) {
            dfs(root.left, path, result);
        }
        if (root.right != null) {
            dfs(root.right, path, result);
        }
        // no need to remove last two character for String
    }
}

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        Deque<TreeNode> stackNode = new LinkedList<TreeNode>();
        Deque<String> stackPath = new LinkedList<String>();
        List<String> result = new ArrayList<String>();
        if (root != null) {
            stackNode.push(root);
            stackPath.push("" + root.val);
        }
        while (!stackNode.isEmpty()) {
            TreeNode node = stackNode.pop();
            String path = stackPath.pop();
            if (node.left == null && node.right == null) {
                result.add(path);
            } else {
                if (node.left != null) {
                    stackNode.push(node.left);
                    stackPath.push(path + "->" + node.left.val);
                }
                if (node.right != null) {
                    stackNode.push(node.right);
                    stackPath.push(path + "->" + node.right.val);
                }
            }
        }
        return result;
    }
}