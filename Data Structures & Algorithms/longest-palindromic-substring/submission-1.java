class Solution {
    public String longestPalindrome(String s) {
       StringBuilder s1 = new StringBuilder(s);
       s1.reverse();
       String s2 = s1.toString();

       int m = s.length();
       int n = s2.length();
       int dp[][] = new int[m+1][n+1];

       for (int i=0;i<=m;i++) dp[i][0] = 0;
       for (int i=0;i<=n;i++) dp[0][i] = 0;

       int endIndex = 0;
       int maxLen = 0;

       for (int i=1;i<=m;i++) {
        for (int j=1;j<=n;j++) {
            if (s.charAt(i-1)==s2.charAt(j-1)) {
                dp[i][j] = 1+dp[i-1][j-1];

                if (i - dp[i][j] == m - j) {
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i-1;
                    }
                }
            } else {
                dp[i][j] = 0;
            }
        }
       } 

    return s.substring(endIndex-maxLen+1, endIndex+1);
    }
}
