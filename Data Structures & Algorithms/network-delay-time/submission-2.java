class Solution {
    class Pair {
        int node;
        int time;
        Pair (int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> adj = new ArrayList<>();
        for (int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0;i<times.length;i++) {
            int ui = times[i][0];
            int vi = times[i][1];
            int ti = times[i][2];
            adj.get(ui).add(new Pair(vi, ti));
        } 

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1]-b[1]); // source node, time

        int time[] = new int[n+1];
        Arrays.fill(time, (int)1e9);
        time[k] = 0;
        time[0] = 0;

        minHeap.offer(new int[]{k,0});

        while(!minHeap.isEmpty()) {
            int[] polled = minHeap.poll();
            int src = polled[0];
            int currTime = polled[1];
            for (Pair neigbour: adj.get(src)) {
                int neigbourTime = neigbour.time;
                int neigbourNode = neigbour.node;
                if (currTime + neigbourTime < time[neigbourNode]) {
                    time[neigbourNode] = currTime+neigbourTime;
                    minHeap.offer(new int[]{neigbourNode, currTime + neigbourTime});
                }
            }
        }

        int maxTime = 0;
        for (int mins:time) {
            if (mins==(int)1e9) {
                return -1;
            }
            maxTime = Math.max(maxTime,mins);
        }        
        
        return maxTime;

    }
}
