/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null) {
            return head;
        }
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode last = dummyHead;
        int numGroup = listLength(head) / k;
        for (int i = 0; i < numGroup; i++) {
            ListNode pre = null;
            ListNode cur = last.next;
            for (int j = 0; j < k; j++) {
                ListNode nextNode = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nextNode;
            }
            ListNode newLast = last.next;
            last.next = pre;
            last = newLast;
            last.next = cur;
        }
        
        return dummyHead.next;
    }
    
    private int listLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}