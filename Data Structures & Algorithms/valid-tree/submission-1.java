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

        if (hasCycle(adj, visited, 0, -1) == true) {
            return false;
        }

        for (int i: visited) {
            if (i == 0) return false;
        }
        
        return true;

    }
    private boolean hasCycle(List<List<Integer>> adj, int[] visited, int element, int parent) {
        visited[element] = 1;
        for (int neighbour: adj.get(element)) {
            if (visited[neighbour] == 0) {
                if (hasCycle(adj, visited, neighbour, element) == true) {
                    return true;
                }
            } else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }
}
 