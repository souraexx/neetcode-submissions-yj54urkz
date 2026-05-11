class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()) {
            return false;
        }

        int n = s1.length();
        int m = s2.length();
        boolean dp[][] = new boolean[n+1][m+1];
        dp[n][m] = true;

        for (int i=n;i>=0;i--) {
            for (int j=m;j>=0;j--) {

                if (i==n && j==m) continue;

                int k = i+j;
                
                // take from s1
                if (i<n && s1.charAt(i)==s3.charAt(k)) {
                    dp[i][j] |= dp[i+1][j];
                } 

                // we do both if and if else because we have to consider the
                // possibility that both first characters are same but using one at first
                // may give incorrect ans, so check the second as well

                // take from s2
                if (j<m && s2.charAt(j)==s3.charAt(k)) {
                    dp[i][j] |= dp[i][j+1];
                }
            }
        }

        return dp[0][0];
    }

    // Recursion

    boolean dfs(int i, int j, String s1, String s2, String s3, int dp[][]) {
        
        if (i==s1.length() && j==s2.length() && (i+j)==s3.length()) {
            return true;
        }
        
        if (dp[i][j]!=-1) {
            boolean ret;
            ret = dp[i][j]==1?true:false;
            return ret;
        } 

        int k = i+j;

        // take from s1
        if (i<s1.length() && s1.charAt(i)==s3.charAt(k)) {
            if (dfs(i+1, j, s1, s2, s3, dp)) {
                dp[i][j] = 1;
                return true;
            }
        }

        // take from s2
        if (j<s2.length() && s2.charAt(j)==s3.charAt(k)) {
            if (dfs(i, j+1, s1, s2, s3, dp)) {
                dp[i][j] = 1;
                return true;
            }
        }

        dp[i][j] = 0;
        return false;
    }
}
