/*
Given a non-negative number represented as a singly linked list of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4
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
    // Time O(n)
    // Space O(1)
    public ListNode plusOne(ListNode head) {
        ListNode newHead = reverse(head);

        ListNode curNode = newHead;
        int carryOver = (curNode.val + 1) / 10;
        curNode.val = (curNode.val + 1) % 10;
        curNode = curNode.next;
        while (curNode != null && carryOver == 1) {
            int oldVal = curNode.val;
            curNode.val = (curNode.val + carryOver) % 10;
            carryOver = (oldVal + carryOver) / 10;
            curNode = curNode.next;
        }
        if (carryOver == 1) {
            ListNode head2 = new ListNode(1);
            head2.next = reverse(newHead);
            return head2;
        }
        newHead = reverse(newHead);
        return newHead;
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Time O(n)
    public ListNode plusOne(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode curNode = dummyHead;
        ListNode startNode = null;
        while (curNode != null && curNode.next != null) {
            if (curNode.val != 9 ) {
                if (curNode.next.val == 9) {
                    startNode = curNode;
                } else {
                    startNode = null;
                }
            }
            curNode = curNode.next;
        }
        // need to exclude dummyHead
        if (curNode != dummyHead && curNode.val != 9) {
            curNode.val = curNode.val + 1;
            startNode = null;
        }
        if (startNode != null) {
            startNode.val = startNode.val + 1;
            startNode = startNode.next;
        }

        while (startNode != null) {
            startNode.val = 0;
            startNode = startNode.next;
        }
        return dummyHead.val == 0 ? dummyHead.next : dummyHead;
    }
}