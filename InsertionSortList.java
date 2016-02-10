/*
Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = null;
        
        while (head != null) {
            ListNode temp = head.next; 
            head.next = null;
            ListNode cur = dummyHead;
            while (cur.next != null) {
                if (head.val == cur.val || head.val > cur.val && head.val <= cur.next.val) {
                    head.next = cur.next;
                    cur.next = head;
                    break;
                }
                cur = cur.next;
            }
            if (cur.next == null) {
                cur.next = head;
            }
            head = temp;
        }
        
        return dummyHead.next;
    }
}