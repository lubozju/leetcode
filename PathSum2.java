/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;    
        }
        dfs(root, sum, new ArrayList<Integer>(), result);
        return result;
    }
    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        path.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
            return;
        }
        if (root.left != null) {
            dfs(root.left, sum, path, result);
        }
        if (root.right != null) {
            dfs(root.right, sum, path, result);
        }
        path.remove(path.size() - 1);
    }
}

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> sumStack = new Stack<Integer>();
        Stack<List<Integer>> pathStack = new Stack<List<Integer>>();
        
        if (root != null) {
            nodeStack.push(root);
            sumStack.push(sum - root.val);
            List<Integer> path = new ArrayList<Integer>();
            path.add(root.val);
            pathStack.push(path);
        }
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int sumNew = sumStack.pop();
            List<Integer> path = pathStack.pop();
            if (node.left == null && node.right == null && sumNew == 0) {
                result.add(path);
            } else {
                if (node.right != null) {
                    nodeStack.push(node.right);
                    sumStack.push(sumNew - node.right.val);
                    List<Integer> pathNew = new ArrayList<Integer>(path);
                    pathNew.add(node.right.val);
                    pathStack.push(pathNew);
                }
                if (node.left != null) {
                    nodeStack.push(node.left);
                    sumStack.push(sumNew - node.left.val);
                    List<Integer> pathNew = new ArrayList<Integer>(path);
                    pathNew.add(node.left.val);
                    pathStack.push(pathNew); 
                }
            }
        }
        return result;
    }
}

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> sumQueue = new LinkedList<Integer>();
        Queue<List<Integer>> pathQueue = new LinkedList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root != null) {
            nodeQueue.add(root);
            sumQueue.add(sum - root.val);
            List<Integer> path = new ArrayList<Integer>();
            path.add(root.val);
            pathQueue.add(path);
        }
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            List<Integer> path = pathQueue.poll();
            Integer sumTemp = sumQueue.poll();
            if (node.left == null && node.right == null && sumTemp == 0) {
                result.add(path);
            }
            if (node.left != null) {
                nodeQueue.add(node.left);
                sumQueue.add(sumTemp - node.left.val);
                List<Integer> newPath = new ArrayList<Integer>(path);
                newPath.add(node.left.val);
                pathQueue.add(newPath);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                sumQueue.add(sumTemp - node.right.val);
                List<Integer> newPath = new ArrayList<Integer>(path);
                newPath.add(node.right.val);
                pathQueue.add(newPath);
            }
        }
        
        return result;
    }
}