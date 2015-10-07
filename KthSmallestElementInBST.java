/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).

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
    private int count = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        return inOrder(root, k);
    }
    
    private Integer inOrder(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        Integer left = inOrder(root.left, k);
        if (left != null) {
            return left;
        }
        count++;
        if (count == k) {
            return root.val;
        }
        Integer right = inOrder(root.right, k);
        return right;
    } 
}