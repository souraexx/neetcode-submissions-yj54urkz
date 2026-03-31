class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int result[] = new int[n];
        int indexedTask[][] = new int[n][3]; // index, enqueue time, processing time
        for (int i=0; i<tasks.length; i++) {
            indexedTask[i][0] = i;
            indexedTask[i][1] = tasks[i][0];
            indexedTask[i][2] = tasks[i][1];
        }
        Arrays.sort(indexedTask, (a,b)->Integer.compare(a[1], b[1]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> {
                if (a[2]==b[2]) {
                    return Integer.compare(a[0],b[0]);
                }
                return Integer.compare(a[2],b[2]);
            }
        );
        int i = 0;
        int index = 0;
        long curTime = 0;
        while(index<n) {
            if (minHeap.isEmpty() && curTime<indexedTask[i][1]) {
                curTime = indexedTask[i][1];
            }
            while(i<n && indexedTask[i][1]<=curTime) {
                minHeap.offer(indexedTask[i]);
                i++;
            }
            int curTask[] = minHeap.poll();
            result[index++] = curTask[0];
            curTime+= curTask[2];
        }
        return result;
    }
}