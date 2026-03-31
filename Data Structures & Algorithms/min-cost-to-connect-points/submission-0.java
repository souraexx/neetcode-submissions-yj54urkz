class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[0]-b[0]); // cost, node

        int visited[] = new int[n];
        int minCost = 0;

        minHeap.offer(new int[]{0,0});

        while(!minHeap.isEmpty()) {
            int[] polled = minHeap.poll();
            int cost = polled[0];
            int node = polled[1];

            if (visited[node]==1) continue;
            visited[node] = 1;
            minCost += cost;

            for (int i=0; i<n; i++) {
                if (visited[i]==0) {
                    int distance = Math.abs(points[node][0]-points[i][0]) +
                                    Math.abs(points[node][1]-points[i][1]);
                    minHeap.offer(new int[] {distance, i});
                }
            }

        } 

        return minCost;
    }
}
