class MyCircularQueue {
    private class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    private Node head, tail;
    private int size, capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
            tail.next = head; // circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // maintain circularity
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : head.val;
    }

    public int Rear() {
        return isEmpty() ? -1 : tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
