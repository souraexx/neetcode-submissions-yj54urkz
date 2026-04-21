class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 1 based indexing
        int dp[][] = new int[m+1][n+1];

        for (int j=0;j<=n;j++) dp[0][j] = j;
        for (int i=0;i<=m;i++) dp[i][0] = i;

        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[m][n];
    }

    // Recursion - 1 based indexing
    int f(int i, int j, String s1, String s2, int dp[][]) {

        if (i==0) return j;
        if (j==0) return i;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i-1)==s2.charAt(j-1)) {
            return dp[i][j] = f(i-1, j-1, s1, s2, dp);
        } else {
            int insert = 1 + f(i, j-1, s1, s2, dp);
            int delete = 1 + f(i-1, j, s1, s2, dp);
            int replace = 1 + f(i-1, j-1, s1, s2, dp);

            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }
}
