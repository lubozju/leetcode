/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val);
                sb.append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append("null");
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] array = data.split(",");
        TreeNode root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (array[0].equals("null")) {
            root = null;
        } else {
            root = new TreeNode(Integer.parseInt(array[0]));
            queue.offer(root);
        }

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (array[i].equals("null")) {
                curNode.left = null;
            } else {
                curNode.left = new TreeNode(Integer.parseInt(array[i]));
                queue.offer(curNode.left);
            }
            i++;
            if (array[i].equals("null")) {
                curNode.right = null;
            } else {
                curNode.right = new TreeNode(Integer.parseInt(array[i]));
                queue.offer(curNode.right);
            }
            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));