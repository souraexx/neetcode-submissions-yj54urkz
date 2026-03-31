class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                }
            }
        }
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for (int x=0;x<size;x++) {
                int cell[] = queue.poll();
                int row = cell[0];
                int col = cell[1];
                for (int dir[]: dirs) {
                    int newRow = row+dir[0];
                    int newCol = col+dir[1];
                    if (newRow<grid.length && newRow>=0 && newCol<grid[0].length 
                        && newCol>=0 && grid[newRow][newCol] == 2147483647 ) {
                            grid[newRow][newCol] = time;
                            queue.offer(new int[] {newRow, newCol});
                    }
                }
            }
        }
    }
}
