class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int prev[] = new int[n];
        for (int i=0; i<m; i++) {
            int temp[] = new int[n];
            for (int j=0; j<n; j++) {
                if (i==0 && j==0) temp[j] = grid[i][j];
                else {
                    int up = (int)1e9, left = (int)1e9;
                    if (i>0) up = grid[i][j] + prev[j];
                    if (j>0) left = grid[i][j] + temp[j-1];
                    temp[j] = Math.min(up, left);
                }
            }
            prev = temp;
        }

        return prev[n-1];
    }

    // Recursion DP

    // int findSum(int i, int j, int[][] grid, int[][] dp) {
    //     if (i==0 && j==0) return grid[i][j];
    //     if (i<0 || j<0) return (int)1e9;

    //     if (dp[i][j] != -1) return dp[i][j];

    //     int up = grid[i][j] + findSum(i-1, j, grid, dp);
    //     int left = grid[i][j] + findSum(i, j-1, grid, dp);

    //     return dp[i][j] = Math.min(up, left);
    // }
}