/*
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
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
    // Space O(n)
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<NodeLevel> queue = new LinkedList<>();
        int min = 0;
        int max = -1;
        if (root != null) {
            queue.add(new NodeLevel(root, 0));
        }
        while (!queue.isEmpty()) {
            NodeLevel nl = queue.poll();
            List<Integer> list = map.get(nl.level);
            if (list == null) {
                list = new ArrayList<>();
                map.put(nl.level, list);
                min = Math.min(min, nl.level);
                max = Math.max(max, nl.level);
            }
            list.add(nl.node.val);
            if (nl.node.left != null) {
                queue.add(new NodeLevel(nl.node.left, nl.level - 1));
            }
            if (nl.node.right != null) {
                queue.add(new NodeLevel(nl.node.right, nl.level + 1));
            }
        }
        // min should be greater than max if root == null
        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        } 
        return result;
    }
    
    
    private static class NodeLevel {
        private TreeNode node;
        private int level;
        
        private NodeLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}