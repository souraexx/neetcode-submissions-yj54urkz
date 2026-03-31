class MedianFinder {

    int size;
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        this.size = 0;
        this.maxHeap = new PriorityQueue<>((a,b)->b-a);
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        size++;
        int signum = compareSize(maxHeap.size(), minHeap.size());
        if (signum == 0) {
            if (!maxHeap.isEmpty() && num>maxHeap.peek()) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
        } else if (signum == 1) {
            if (num<maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        } else {
            if (num>minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
        }
    }
    
    public double findMedian() {
        int signum = compareSize(maxHeap.size(), minHeap.size());
        if (signum == 0) {
            return ((double)(minHeap.peek()+maxHeap.peek()))/2;
        } else if (signum == 1) {
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

    private int compareSize(int a, int b) {
        if (a == b) return 0;
        else if (a > b) return 1;
        else return -1;
    } 
}
