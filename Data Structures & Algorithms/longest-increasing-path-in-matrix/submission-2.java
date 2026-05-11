class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int dp[][] = new int[m+1][n+1];
        for (int row[]: dp) {
            Arrays.fill(row, -1);
        }

        int ans = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                ans = Math.max(ans,
                        dfs(i, j, matrix, dp));
            }
        }  

        return ans; 
    }
    int dfs(int row, int col, int matrix[][], int dp[][]) {

        if (dp[row][col]!=-1) return dp[row][col];

        int m = matrix.length;
        int n = matrix[0].length;

        int dirs[][] = {{-1,0}, {1,0}, {0,1}, {0,-1}};

        int length = 1;

        for (int dir[]: dirs) {
            int newRow = row+dir[0];
            int newCol = col+dir[1];

            if (newRow>=m || newRow<0 || newCol>=n || newCol<0) continue;

            if (matrix[newRow][newCol]>matrix[row][col]) {
                length = Math.max(length, 1+dfs(newRow, newCol, matrix, dp));
            }

        }

        return dp[row][col] = length;

    }
}
