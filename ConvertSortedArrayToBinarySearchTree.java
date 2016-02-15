/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }
    
    private TreeNode help(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums, start, mid - 1);
        root.right = help(nums, mid + 1, end);
        return root;
    }
}

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        Queue<MyNode> queue = new LinkedList<>();
        int left = 0;
        int right = nums.length - 1;
        
        MyNode root = new MyNode(new TreeNode(nums[left + (right - left) / 2]), left, right);
        queue.add(root);
        
        while (!queue.isEmpty()) {
            MyNode node = queue.poll();
            left = node.lb;
            right = node.rb;
            TreeNode n = node.node;
            int mid = left + (right - left) / 2;
            if (left < mid) {
                n.left = new TreeNode(nums[left + (mid - 1 - left) / 2]);
                MyNode ln = new MyNode(n.left, left, mid - 1);
                queue.add(ln);
            }
            if (right > mid) {
                n.right = new TreeNode(nums[mid + 1 + (right - (mid + 1)) / 2]);
                MyNode rn = new MyNode(n.right, mid + 1, right);
                queue.add(rn);
            }
        }
        return root.node;
    }
    
    private static class MyNode {
        TreeNode node;
        int lb;
        int rb;
        public MyNode(TreeNode node, int lb, int rb) {
            this.node = node;
            this.lb = lb;
            this.rb = rb;
        }
    }
}