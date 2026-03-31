class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->{return a[0]-b[0];}); // absolute height, i, j
        minHeap.offer(new int[]{0, 0, 0});

        int[][] minEffort = new int[row][col];
        for (int rows[]:minEffort) {
            Arrays.fill(rows, (int)1e9);
        }
        minEffort[0][0] = 0;

        int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};

        while(!minHeap.isEmpty()) {
            int polled[] = minHeap.poll();

            int effort = polled[0];
            int currRow = polled[1];
            int currCol = polled[2];

            for (int dir[]: dirs) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];

                if ((newRow<row) && (newCol<col) && (newRow>=0) && (newCol>=0)) {
                    int diff = Math.abs(heights[currRow][currCol]-heights[newRow][newCol]);
                    int newEffort = Math.max(effort, diff);

                    if (newEffort<minEffort[newRow][newCol]) {
                        minEffort[newRow][newCol] = newEffort;
                        minHeap.offer(new int[]{newEffort, newRow, newCol});
                    }
                }
            }
        }

        return minEffort[row-1][col-1];
    }
}