/*
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Removing the leaves [4, 5, 3] would result in this tree:

          1
         / 
        2          
2. Now removing the leaf [2] would result in this tree:

          1          
3. Now removing the leaf [1] would result in the empty tree:

          []         
Returns [4, 5, 3], [2], [1].
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
    // O(n)
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        List<List<Integer>> left = findLeaves(root.left);
        
        List<List<Integer>> right = findLeaves(root.right);
        
        result.addAll(merge(left, right));
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        result.add(rootList);
        return result;
    }
    
    private List<List<Integer>> merge(List<List<Integer>> list1, List<List<Integer>> list2) {
        List<List<Integer>> result = new ArrayList<>();
        
        int i = 0;
        while (i < list1.size() && i < list2.size()) {
            list1.get(i).addAll(list2.get(i));
            result.add(list1.get(i));
            i++;
        }
        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }
        
        while (i < list2.size()) {
            result.add(list2.get(i));
            i++;
        }
        return result;
    }
}

public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        findHeight(root, result);
        return result;
    }
    
    private int findHeight(TreeNode node, List<List<Integer>> result) {
        if (node == null) {
            return -1;
        }
        
        int height = 1 + Math.max(findHeight(node.left, result), findHeight(node.right, result));
        
        if (result.size() == height) {
            result.add(new ArrayList<>());
        }
        List<Integer> list  = result.get(height);
        list.add(node.val);
        return height;
    }
}