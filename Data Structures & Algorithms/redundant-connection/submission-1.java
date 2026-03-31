class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;

        for (int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[]: edges) {
            int u = edge[0];
            int v = edge[1];

            int visited[] = new int[n+1];
            if (dfs(u, v, adj, visited)) {
                return edge;
            }

            adj.get(u).add(v);
            adj.get(v).add(u);

        }

        return new int[0];
    } 

    private boolean dfs(int source, int target, List<List<Integer>> adj, int visited[]) {
        visited[source] = 1;

        if (source == target) {
            return true;
        }
        for (int neighbour:adj.get(source)) {
            if (visited[neighbour] == 0) {
                if (dfs(neighbour, target, adj, visited)) return true;
            }
        }
        return false;
    } 
}
