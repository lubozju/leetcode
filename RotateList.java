/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = listLength(head);
        k = k % length;
        if (k == 0) {
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            while (k > 0) {
                fast = fast.next;
                k--;
            }
            if (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
    
    private int listLength(ListNode head) {
        int result = 0;
        while (head != null) {
            result++;
            head = head.next;
        }
        return result;
    }
}