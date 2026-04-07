class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i==0 && j==0) dp[i][j] = grid[i][j];
                else {
                    int up = (int)1e9, left = (int)1e9;
                    if (i>0) up = grid[i][j] + dp[i-1][j];
                    if (j>0) left = grid[i][j] + dp[i][j-1];
                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[m-1][n-1]; 
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