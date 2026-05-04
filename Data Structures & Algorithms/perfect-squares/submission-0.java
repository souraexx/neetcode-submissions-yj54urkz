class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        for (int i=1;i<=n;i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j=1;j*j<=i;j++) {
                if (i-(j*j)>=0) {
                    int result = 1+dp[i-(j*j)];
                    minSteps = Math.min(minSteps, result);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n];
    }

    // Recursion
    int f(int n) {

        if (n==0) return 0;
        
        int minSteps = Integer.MAX_VALUE;
        for (int i=1; i*i<=n;i++) {
            int result = f(n-(i*i));
            minSteps = Math.min(minSteps, result+1);
        }
        return minSteps;
    }
}