/*
Sort a linked list in O(n log n) time using constant space complexity.
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // fast moves one step earlier
        ListNode fast = head.next.next;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode secondHead = sortList(slow.next);
        
        slow.next = null;
        
        ListNode firstHead = sortList(head);
        
        return merge(firstHead, secondHead);
    }
    
    // firstHead and secondHead will not be null
    private ListNode merge(ListNode firstHead, ListNode secondHead) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
   
        while (firstHead != null && secondHead != null) {
            if (firstHead.val < secondHead.val) {
                cur.next = firstHead;
                firstHead = firstHead.next;
            } else {
                cur.next = secondHead;
                secondHead = secondHead.next;
            }
            cur = cur.next;
        }
        if (firstHead != null) {
            cur.next = firstHead;
        } else {
            cur.next = secondHead;
        }
        return dummyHead.next;
    }
}