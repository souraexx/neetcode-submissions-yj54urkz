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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sumHead = new ListNode();
        ListNode temp = sumHead;
        while (l1!=null || l2!=null) {
            int x = l1!=null ? l1.val : 0;
            int y = l2!=null ? l2.val : 0;
            int sum = x+y+carry;
            int modifiedSum = sum%10;
            carry = sum/10;
            temp.next = new ListNode(modifiedSum,null);

            if (l1!=null) l1=l1.next;
            if (l2!=null) l2=l2.next;
            temp = temp.next;
        }
        if (carry > 0) {
            ListNode finalNode = new ListNode(carry, null);
            temp.next = finalNode;
        }
        return sumHead.next;
    }
}
