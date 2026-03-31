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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2 = reverseList(slow.next);
        slow.next = null;
        ListNode temp = head;
        while(head2!=null) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = head2.next;

            head.next = head2;
            head2.next = tmp1;

            head = tmp1;
            head2 = tmp2;
        }
    }
     
    public ListNode reverseList(ListNode head) {
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
