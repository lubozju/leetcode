/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> oldToNew = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode cur = head;
        while (cur != null) {
            oldToNew.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        
        cur = head;
        while (cur != null) {
            oldToNew.get(cur).next = oldToNew.get(cur.next);
            if (cur.random == null) {
                oldToNew.get(cur).random = null;
            } else {
                oldToNew.get(cur).random = oldToNew.get(cur.random);
            }
            cur = cur.next;
        } 
        return oldToNew.get(head);
    }
}