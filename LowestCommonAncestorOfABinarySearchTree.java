/**
*Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
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
 
 /**
  *  Complexity: O(log_2(n))
  */ 
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        
        if (root.val > p.val) {
            if (root.val < q.val) {
                return root;
            }
            return lowestCommonAncestor(root.left, p, q);
        } else {
            if (root.val > q.val) {
                return root;
            }
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        while (root != p && root != q) {
            if (root.val > p.val) {
                if (root.val < q.val) {
                    return root;
                }
                root = root.left;
            } else {
                if (root.val > q.val) {
                    return root;
                }
                root = root.right;
            }
        }
        
        return root;
    }
}