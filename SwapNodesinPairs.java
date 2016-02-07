/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode curNode = dummyHead;
        
        while (curNode.next != null && curNode.next.next != null) {
            ListNode first = curNode.next;
            ListNode second = first.next;
            
            curNode.next = second;
            // remove the loop
            first.next = second.next;
            second.next = first;
            curNode = first;
        }
        
        return dummyHead.next;
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode first = head;
        ListNode second = head.next;
        
        ListNode tailNode = swapPairs(second.next);
        first.next = tailNode;
        second.next = first;
        head = second;
        
        return head;
    }
}