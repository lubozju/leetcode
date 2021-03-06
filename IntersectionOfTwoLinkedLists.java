/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        
        if (lengthA > lengthB) {
            return help(headA, headB, lengthA, lengthB);
        } else {
            return help(headB, headA, lengthB, lengthA);
        }
    }
    private ListNode help(ListNode longList, ListNode shortList, int longLength, int shortLength) {
        while (longLength > shortLength) {
            longList = longList.next;
            longLength--;
        }
        
        while (shortList != null) {
            if (longList.val == shortList.val) {
                return shortList;
            }
            longList = longList.next;
            shortList = shortList.next;
        }
        
        return shortList;
    }
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    
}