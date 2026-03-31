class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) return false;
        
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n];
        
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int edge[]:edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        queue.offer(0);
        while (!queue.isEmpty()) {
            int element = queue.poll();
            visited[element] = 1;
            for (int neighbour:adj.get(element)) {
                if (visited[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        for (int i: visited) {
            if (i == 0) return false;
        }
        
        return true;

    }
}
 