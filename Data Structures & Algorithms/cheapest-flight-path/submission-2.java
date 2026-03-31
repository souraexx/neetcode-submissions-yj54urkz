class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int cost_dist[] = new int[n];
        Arrays.fill(cost_dist, (int)1e9);
        cost_dist[src] = 0;

        int temp[];

        // bellman ford for k+1 edges
        for(int i=0;i<=k;i++) {
            temp = Arrays.copyOf(cost_dist, n);
            for (int[] flight:flights) {
                int u = flight[0];
                int v = flight[1];
                int cost = flight[2];
                //In round i, only use paths that were built in round i-1. Never use something you just updated in this same round.
                if (cost_dist[u]!=(int)1e9 && cost_dist[u]+cost<temp[v]) {
                    temp[v] = cost_dist[u]+cost;
                }
            }
            cost_dist = temp;
        }

        if (cost_dist[dst]==(int)1e9) {
            return -1;
        }
        return cost_dist[dst];
    }
}
