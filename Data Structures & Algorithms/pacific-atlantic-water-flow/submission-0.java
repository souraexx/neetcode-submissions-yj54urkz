class Solution {
    private void dfs(int[][]heights, int[][] visited, int i, int j, int parent) {
        int m = heights.length;
        int n = heights[0].length;
        if (i>=m || j>=n || i<0 || j<0 || visited[i][j]==1 || heights[i][j]<parent) {
            return;
        }
        visited[i][j] = 1;
        dfs(heights, visited, i+1, j, heights[i][j]);
        dfs(heights, visited, i-1, j, heights[i][j]);
        dfs(heights, visited, i, j+1, heights[i][j]);
        dfs(heights, visited, i, j-1, heights[i][j]);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] pacific = new int[rows][cols];
        int[][] atlantic = new int[rows][cols];
        for (int i=0;i<rows;i++) {
            // left column
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
            // right column 
            dfs(heights, atlantic, i, cols-1, Integer.MIN_VALUE);
        }
        for (int j=0;j<cols;j++) {
            // top row
            dfs(heights, pacific, 0, j, Integer.MIN_VALUE);
            // bottom row
            dfs(heights, atlantic, rows-1, j, Integer.MIN_VALUE);
        }
        for(int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if ((atlantic[i][j]==1) && (pacific[i][j]==1)) {
                    result.add(new ArrayList<>(Arrays.asList(i,j)));
                } 
            }
        }
        return result;
    }
}
