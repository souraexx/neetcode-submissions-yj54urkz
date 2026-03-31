
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode dummyHead = new ListNode(-1);
        ListNode prevTail = dummyHead;
        ListNode prevHead = head;
        ListNode nextNode = null;
        int count = 0;
        while (temp!=null) {
            count++;
            if (count == k) {

                nextNode = temp.next;
                temp.next = null;
                ListNode newHead = reverseList(prevHead);

                prevTail.next = newHead;
                prevTail = prevHead;

                prevHead = nextNode;
                temp = nextNode;
                count = 0;
            } else {
                temp = temp.next;
            }
        }
        prevTail.next = prevHead;
        return dummyHead.next;
    }
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode temp = head;
        while (temp!=null) {
            ListNode nextElement = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextElement;
        }
        return prev;
    }
}
// 1 2 3 4 5 6 // k = 2
