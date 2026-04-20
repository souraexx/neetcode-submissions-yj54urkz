class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int prev[] = new int[n+1];

        prev[0] = 1;

        for(int i=1;i<=m;i++) {
            for (int j=n;j>=1;j--) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    prev[j] = prev[j-1] + prev[j];
                }
                // } else {
                //     prev[j] = prev[j];
                // }
            }
        }

        return prev[n];
    }

    // Recursion
    int f(int i, int j, String s, String t, int dp[][]) {

        if (j==0) return 1;
        else if (i==0) return 0;

        if (dp[i][j]!=-1) return dp[i][j];

        if (s.charAt(i-1)==t.charAt(j-1)) {
            return dp[i][j] = f(i-1, j-1, s, t, dp) + f(i-1, j, s ,t, dp);
        } else {
            return dp[i][j] = f(i-1, j, s, t, dp);
        }
    }
}
