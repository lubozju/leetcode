/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummySmall = new ListNode(0);
        ListNode dummyGe = new ListNode(0);
        
        ListNode smallCur = dummySmall;
        ListNode geCur = dummyGe;
        
        while (head != null) {
            if (head.val < x) {
                smallCur.next = head;
                smallCur = smallCur.next;
            } else {
                geCur.next = head;
                geCur = geCur.next;   
            }
            head = head.next;
        }
        
        geCur.next = null;
        
        smallCur.next = dummyGe.next;
        
        return dummySmall.next;
    }
}