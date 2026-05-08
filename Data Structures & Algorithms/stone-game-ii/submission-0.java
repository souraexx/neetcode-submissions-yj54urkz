class Solution {
    int suffix[];
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        suffix = new int[n];
        suffix[n-1] = piles[n-1];
        for (int i=n-2;i>=0;i--) {
            suffix[i]+= suffix[i+1] + piles[i];
        }
        int dp[][] = new int[n][n];
        for(int row[]: dp) {
            Arrays.fill(row, -1);
        }

        return f(piles, 0, 1, dp);

    }

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