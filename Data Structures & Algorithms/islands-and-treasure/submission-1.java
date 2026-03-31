class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if (grid[i][j]== 0) {
                    queue.offer(new int[]{i,j});
                }
            }
        } 

        int dirs[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while(!queue.isEmpty()) {
            int size = queue.size();
            time++;
            for(int i=0;i<size;i++) {
                int cell[] = queue.poll();
                for(int dir[]:dirs) {
                    int newRow = cell[0]+dir[0];
                    int newCol = cell[1]+dir[1];
                    if (newRow>=0 && newRow<row && newCol>=0 
                    && newCol<col && grid[newRow][newCol] == 2147483647) {
                        grid[newRow][newCol] = time;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

    }
}
