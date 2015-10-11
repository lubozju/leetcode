/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
    public List<Integer> rightSideView(TreeNode root) {
        int sizePerLayer = 0;
        int tempSize = 0;
        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if (root != null) {
            queue.offer(root);
            sizePerLayer = 1;
        }
        
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();

            if (curNode.left != null) {
                queue.offer(curNode.left);
                tempSize++;
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
                tempSize++;
            }
            // need to update the child queue before updating the sizePerLayer
            sizePerLayer--;
            if (sizePerLayer == 0) {
                result.add(curNode.val);
                sizePerLayer = tempSize;
                tempSize = 0;
            }
        }
        
        return result;
    }
}