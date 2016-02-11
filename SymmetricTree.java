/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> leftStack = new Stack<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        
        TreeNode root1 = root.left;
        TreeNode root2 = root.right;
        leftStack.push(root1);
        rightStack.push(root2);
        
        while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            root1 = leftStack.pop();
            root2 = rightStack.pop();
            while (root1 != null && root2 != null) {
                if (root1.val != root2.val) {
                    return false;
                }
                if (root1.right != null) {
                    leftStack.push(root1.right);
                }
                root1 = root1.left;
            
                if (root2.left != null) {
                    rightStack.push(root2.left);
                }
            
                root2 = root2.right;
            }
            if (root1 != root2) {
                return false;
            }
        }
        return leftStack.isEmpty() && rightStack.isEmpty();
    }
}

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isReverse(root.left, root.right);
    }
    
    private boolean isReverse(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 == null) {
            return false;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        
        if (root1.val != root2.val) {
            return false;
        }
        return isReverse(root1.left, root2.right) && isReverse(root1.right, root2.left);
    }
}