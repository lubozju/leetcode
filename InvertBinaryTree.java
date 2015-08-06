/*Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        TreeNode leftRoot = invertTree(root.left);
        
        TreeNode rightRoot = invertTree(root.right);
        
        root.left = rightRoot;
        root.right = leftRoot;
        
        return root;
    }
}

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if (root != null) {
            queue.add(root);
        }
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            
            if (node.left != null) {
                queue.add(node.left);
            }
            
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        
        return root;
    }
}