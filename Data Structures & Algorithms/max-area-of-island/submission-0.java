class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int area=0;
        int maxArea=0;
        for(int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if (grid[i][j]==1) {
                    area = dfs(grid, i, j, 0);
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int i, int j, int area) {
        if (i>=grid.length || j>=grid[0].length || i<0 || j<0 || grid[i][j]==0) {
            return area;
        }
        grid[i][j] = 0;

        return 1 + dfs(grid, i+1, j, area)
            + dfs(grid, i-1, j, area) + dfs(grid, i, j+1, area) 
            + dfs(grid, i, j-1, area);
    }
}
