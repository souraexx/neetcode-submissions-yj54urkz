class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[2]-b[2]); // i, j, height
        
        int elevation[][] = new int[n][n];
        for (int[] row: elevation) {
            Arrays.fill(row, (int)1e9);
        }
        elevation[0][0] = grid[0][0];

        boolean visited[][] = new boolean[n][n];
        
        minHeap.offer(new int[]{0, 0, grid[0][0]});
        
        int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!minHeap.isEmpty()) {
            int[] polled = minHeap.poll();
            int i = polled[0];
            int j = polled[1];
            int k = polled[2]; //elevation;

            if (visited[i][j]) continue;
            visited[i][j] = true;

            if (i==n-1 && j==n-1) return k;

            for (int[] dir: dirs) {
                int newRow = i+dir[0];
                int newCol = j+dir[1];
                if (newRow>=0 && newRow<n && newCol>=0 && newCol<n) {
                    int newElevation = Math.max(k, grid[newRow][newCol]);
                    if (newElevation<elevation[newRow][newCol] && !visited[newRow][newCol]) {
                        elevation[newRow][newCol] = newElevation;
                        minHeap.offer(new int[] {newRow, newCol, newElevation});
                    }
                }
            }
        }

        return elevation[n-1][n-1];
    }
}
