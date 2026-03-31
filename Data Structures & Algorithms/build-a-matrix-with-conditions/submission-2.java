class Solution {
    private int [] toposort(int[][] arrs, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int arr[]: arrs) {
            adj.get(arr[0]).add(arr[1]);
        }
        for (int i=1;i<=n; i++) {
            for (int neighbours: adj.get(i)) {
                indegree[neighbours]++;
            }
        }
        for (int i=1;i<=n;i++) {
            if (indegree[i]==0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int element = queue.poll();
            result.add(element);
            for (int neighbours: adj.get(element)) {
                indegree[neighbours]--;
                if (indegree[neighbours] == 0) {
                    queue.offer(neighbours);
                }
            }
        }

        if (result.size() == n) {
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
        return null;
    } 
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        // get the ordering of rows and columns
        int[] rowPositions = toposort(rowConditions,k);
        int[] colPositions = toposort(colConditions,k);

        if (rowPositions == null || colPositions == null) {
            return new int[][]{};
        }
        
        // mapping of rows and columns
        int[] rows = new int[k+1];
        int[] cols = new int[k+1];
        for (int i=0;i<k;i++) {
            rows[rowPositions[i]] = i;
            cols[colPositions[i]] = i;
        }

        // map into the matrix
        int[][] result = new int[k][k]; 
        for (int i=1;i<=k;i++) {
            result[rows[i]][cols[i]] = i;
        }

        return result;
    }
}