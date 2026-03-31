/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // put copy in between each nodes
        Node temp = head;
        while (temp!=null) {
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
        temp = head;
        // connect the randoms
        while (temp!=null) {
            Node copyNode  = temp.next;
            if (temp.random !=null) {
                copyNode.random = temp.random.next;
            } else {
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
        // connect the nexts
        Node dummyhead = new Node(-1);
        Node res = dummyhead;
        temp = head;
        while (temp!=null) {
            res.next = temp.next;
            if (temp.next.next!=null) {
                temp.next = temp.next.next;
            } else {
                temp.next = null;
            }

            res = res.next;
            temp = temp.next;
        }
        res.next = null;
        return dummyhead.next;
    }
}
