/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        int size = lists.length;
        Comparator<ListNode> nodeComp = new Comparator<ListNode>() {
          public int compare(ListNode o1, ListNode o2) {
              return o1.val - o2.val;
          }
        };
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(size, nodeComp);
        
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }
        ListNode cur = dummyHead;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (node.next != null) {
                heap.add(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }
        return dummyHead.next;
        
    }
}