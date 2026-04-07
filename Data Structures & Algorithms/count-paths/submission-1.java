class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i==0 && j==0) dp[i][j] = 1;
                else {
                    int up = 0, right = 0;
                    if (i>0) up = dp[i-1][j];
                    if (j>0) right = dp[i][j-1];
                    dp[i][j] = up+right;  
                }
            }
        }
        return dp[m-1][n-1];
    }
    // Recursion dp
    // int findPath(int i, int j, int dp[][]) {
    //     if (i==0 && j==0) return 1;
    //     if (i<0 || j<0) return 0;

    //     if (dp[i][j] != -1) return dp[i][j];

    //     int up = findPath(i-1, j, dp);
    //     int right = findPath(i, j-1, dp);

    //     return dp[i][j] = up+right;
    // }
}
