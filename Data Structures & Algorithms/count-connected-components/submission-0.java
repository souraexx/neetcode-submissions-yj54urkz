class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] visited = new int[n];
        for (int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for (int edge[]:edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        for(int i=0;i<n;i++) {
            if (visited[i]==0) {
                dfs(adj, visited, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(List<List<Integer>> adj, int[] visited, int node) {
        if (visited[node] == 1) {
            return;
        }
        visited[node] = 1;
        for (int i:adj.get(node)) {
            dfs(adj, visited, i);
        }
    }
}
