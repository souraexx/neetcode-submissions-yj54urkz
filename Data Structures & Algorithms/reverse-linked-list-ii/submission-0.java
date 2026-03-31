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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = head;
        dummyHead.next = head;
        ListNode prevLeft = dummyHead;
        for (int i = 1; i<left;i++) {
            prevLeft = temp;
            temp = temp.next;
        }
        ListNode cur = temp;
        ListNode prev = null;
        for (int i = 1; i<=(right-left+1); i++) {
            ListNode tempNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNext;
        }

        prevLeft.next.next = cur;
        prevLeft.next = prev;

        return dummyHead.next;
    }
}
// 1 2 3 4 5 6 7 8
//     3      6