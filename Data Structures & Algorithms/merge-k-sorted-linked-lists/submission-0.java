/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b. val);
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        for (int i=0; i<lists.length; i++) {
            pq.add(lists[i]);
        }
        while (!pq.isEmpty()) {
            ListNode polledNode = pq.poll();
            temp.next = polledNode;
            if (polledNode.next != null) {
                pq.add(polledNode.next);
            }
            temp = temp.next;
        }
        return dummyHead.next;
    }
}
