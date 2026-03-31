class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> empty = new ArrayList<>();
        empty.add(0);
        if (n == 1) return empty;

        List<List<Integer>> adj = new ArrayList<>();
        int degree[] = new int[n];
        for (int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }   
        for (int edge[]:edges) {
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
            degree[a]++;
            degree[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        int remaining = n;
        while (remaining>2) {
            int size = queue.size();
            remaining -= size;
            for (int i=0;i<size;i++) {
                int element = queue.poll();
                for (int neig : adj.get(element)) {
                    degree[neig]--;
                    if (degree[neig] == 1) {
                        queue.offer(neig);
                    }
                }
            }
        }

        return new ArrayList<>(queue);
    }
}