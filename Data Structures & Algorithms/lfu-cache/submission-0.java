class LFUCache {

    class Node {
        int key, val, freq;
        Node prev, next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            freq = 1;
        }
    }

    class DLList {
        int size;
        Node head, tail;
        public DLList () {
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }

        void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            Node previous = node.prev;
            Node nextNode = node.next;
            previous.next = nextNode;
            nextNode.prev = previous;
            size--;
        }
    }

    int capacity,size,minFreq;
    Map<Integer, Node> nodeMap;
    Map<Integer, DLList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
        this.size = 0;       
        this.minFreq = 0; 
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        } else {
            Node node = nodeMap.get(key);
            update(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.val = value;
            update(node);
        } else {
            if (size == capacity) {
                DLList minList = freqMap.get(minFreq);
                Node toRemove = minList.tail.prev;
                minList.remove(toRemove);
                nodeMap.remove(toRemove.key);
                size--;
            }
            Node node = new Node(key, value);
            nodeMap.put(key, node);
            freqMap.computeIfAbsent(1, k->new DLList()).addToHead(node);
            minFreq = 1;
            size++;
        }
        
    }

    private void update(Node node) {
        DLList list = freqMap.get(node.freq);
        list.remove(node);

        if (node.freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DLList()).addToHead(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */