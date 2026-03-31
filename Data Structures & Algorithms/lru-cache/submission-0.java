class LRUCache {

    private class DoubleList {
        DoubleList prev,next;
        int key, val;
        DoubleList(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    HashMap<Integer, DoubleList> map;
    DoubleList head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DoubleList(0, 0);
        tail = new DoubleList(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DoubleList node = map.get(key);
        deleteNode(node);
        insertAtHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleList node = map.get(key);
            node.val = value;
            deleteNode(node);
            insertAtHead(node);
            map.put(key, node);
        } else {
            if (map.size() == capacity) {
                DoubleList last = tail.prev;
                deleteNode(last);
                map.remove(last.key);
            }
            DoubleList node = new DoubleList(key, value);
            map.put(key, node);
            insertAtHead(node);
        }
    }

    private void insertAtHead(DoubleList node) {
        DoubleList nextNode = head.next;
        head.next = node;
        node.next = nextNode;
        nextNode.prev = node;
        node.prev = head;
    }

    private void deleteNode(DoubleList node) {
        DoubleList prevNode = node.prev;
        DoubleList nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}
