/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<TreeNode>();
        dfs(root, p, pathP);
        
        List<TreeNode> pathQ = new ArrayList<TreeNode>();
        dfs(root, q, pathQ);
        int i;
        for (i = 0; i < Math.min(pathQ.size(), pathP.size()); i++) {
            TreeNode nodeP = pathP.get(i);
            TreeNode nodeQ = pathQ.get(i);
            if (nodeP != nodeQ) {
                return pathP.get(i - 1);
            }
        }
        return pathP.get(i - 1);
    }
    
    private boolean dfs(TreeNode node, TreeNode target, List<TreeNode> path) {
        path.add(node);
        if (node == target) {
            return true;
        }
        if (node.left != null) {
            if (dfs(node.left, target, path)) {
                return true;
            }
        }
        if (node.right != null) {
            if (dfs(node.right, target, path)) {
                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;
    }
}