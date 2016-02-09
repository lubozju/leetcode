/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode evenHead = head.next;
        ListNode curOdd = head;
        ListNode curEven = evenHead;
        // check odd is not neccessary since curEven is always to the right
        while (curEven != null && curEven.next != null) {
            curOdd.next = curOdd.next.next;
            curEven.next = curEven.next.next;
            curOdd = curOdd.next;
            curEven = curEven.next;
        }
        
        curOdd.next = evenHead;
        return dummyHead.next;
    }
}