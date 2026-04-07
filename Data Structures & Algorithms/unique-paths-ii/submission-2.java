class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int prev[] = new int[n];
        
        for (int i=0; i<m; i++) {
            int temp[] = new int[n];
            for (int j=0; j<n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    temp[j] = 0;
                } else if (i==0 && j==0) {
                    temp[j] = 1;
                } else {
                    int up = 0, left = 0;
                    if (i>0) up = prev[j];
                    if (j>0) left = temp[j-1];
                    temp[j] = up+left;
                }
            }
            prev = temp;
        }
        return prev[n-1];
    }

    // Recursion DP

    // int findPath(int i, int j, int dp[][], int[][] obstacleGrid) {
    //     if (i>=0 && j>=0 && obstacleGrid[i][j]==1) return 0;
    //     if (i==0 && j==0) return 1;
    //     if (i<0 || j<0) return 0;

    //     if (dp[i][j] != -1) return dp[i][j];

    //     int up = findPath(i-1, j, dp, obstacleGrid);
    //     int left = findPath(i, j-1, dp, obstacleGrid);

    //     return dp[i][j] = up+left;
    // }
}