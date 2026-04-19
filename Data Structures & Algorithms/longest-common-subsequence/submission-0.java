class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int dp[][] = new int[m+1][n+1];
        for (int i=0;i<=m;i++) dp[i][0] = 0;
        for (int i=0;i<=n;i++) dp[0][i] = 0;

        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

    // Recursion - 1 based indexing

    int f(int index1, int index2, String s1, String s2) {

        if (index1==0 || index2==0) return 0;

        if (s1.charAt(index1-1) == s2.charAt(index2-1)) {
            return 1 + f(index1-1, index2-1, s1, s2);
        } else {
            return Math.max(
                f(index1-1, index2, s1, s2),
                f(index1, index2-1, s1, s2)
            );
        }
    }
}
