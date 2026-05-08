class Solution {
    public boolean stoneGame(int[] piles) {
        int dp[][] = new int[piles.length][piles.length];
        for (int row[]: dp) {
            Arrays.fill(row, -1);
        }

        return(f(piles, 0, piles.length-1, dp)>0);
    }
    int f(int piles[], int i, int j, int dp[][]) {
        
        if (i>j) return 0;

        if (dp[i][j]!=-1) return dp[i][j];

        int pickLeft = piles[i] - f(piles, i+1, j, dp);
        int pickRight = piles[j] - f(piles, i, j-1, dp);

        return dp[i][j] = Math.max(pickLeft, pickRight);
    }
}