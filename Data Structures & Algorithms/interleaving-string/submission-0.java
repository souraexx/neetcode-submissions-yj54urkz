class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()) {
            return false;
        }

        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for (int row[]: dp) {
            Arrays.fill(row, -1);
        }

        return dfs(0, 0, s1, s2, s3, dp);
    }

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
