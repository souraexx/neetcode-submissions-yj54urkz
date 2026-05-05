class Solution {
    public int integerBreak(int n) {
        int dp[] = new int[n+1];
        
        dp[1] = 1;

        for (int i=2;i<=n;i++) {
            for (int j=1;j<i;j++) {
                dp[i] = Math.max(dp[i], j*Math.max(i-j, dp[i-j]));
            }
        }

        return dp[n];
    }

    // Recursion

    int f(int n, boolean mustBreak) {
        
        if (n==0) return 1;

        int max = mustBreak? 0:n;

        for (int i=1;i<n;i++) {
            max = Math.max(max, i*f(n-i, false));
        }
        return max;
    }
}