class Solution {
    int suffix[];
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        suffix = new int[n];
        suffix[n-1] = piles[n-1];
        for (int i=n-2;i>=0;i--) {
            suffix[i]+= suffix[i+1] + piles[i];
        }

        int dp[][] = new int[n+1][n+1];
        
        for(int i=n-1;i>=0;i--) {
            for (int j=n; j>=1; j--) {
                if (i+2*j>=n) {
                    dp[i][j] = suffix[i];
                    continue;
                }


                int sum = 0;
                for (int X=1; X<=2*j; X++) {
                    int stones = suffix[i] - dp[i+X][Math.max(j, X)];
                    sum = Math.max(sum, stones);
                }
                dp[i][j] = sum;
            }
        }

        return dp[0][1];

    }

    // Recursion
    int f(int piles[], int i, int M, int dp[][]) {
        if (i>=piles.length) return 0;

        if (i+2*M>=piles.length) return suffix[i];

        if (dp[i][M]!=-1) return dp[i][M];

        int sum = 0;
        for (int X=1; X<=2*M; X++) {
            int stones = suffix[i] - f(piles, i+X, Math.max(M, X), dp);
            sum = Math.max(sum, stones);
        }
        return dp[i][M] = sum;
    }
}