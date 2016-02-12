/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode cur = root;
            root = null;
            TreeLinkNode pre = null;
            while (cur != null) {
                while (cur != null && cur.left == null && cur.right == null) {
                    cur = cur.next;
                }
                if (cur == null) {
                    break;
                }
                if (cur.left != null) {
                    if (pre == null) {
                        pre = cur.left;
                        root = pre;
                    } else {
                        pre.next = cur.left;
                        pre = pre.next;
                    }
                }
                if (cur.right != null) {
                    if (pre == null) {
                        pre = cur.right;
                        root = pre;
                    } else {
                        pre.next = cur.right;
                        pre = pre.next;
                    }
                }
                cur = cur.next;
            }
        }
    }
}