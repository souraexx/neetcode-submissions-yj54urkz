class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];

        for (int i=0;i<=amount;i++) {
            if (i%coins[0] == 0) {
                dp[0][i] = 1;
            }
        }

        for(int i=1;i<n;i++) {
            for (int j=0;j<=amount;j++) {
                int notPick = dp[i-1][j];
                int pick = 0;
                if (coins[i]<=j) {
                    pick = dp[i][j-coins[i]];
                }
                dp[i][j] = pick+notPick;
            }
        }

        return dp[n-1][amount];
    }

    // Recursion

    // int f(int index, int coins[], int amount, int dp[][]) {

    //     if (index == 0) {
    //         if (amount%coins[0] == 0) return 1;
    //         return 0;
    //     }

    //     if (dp[index][amount]!=-1) return dp[index][amount];

    //     int notPick = f(index-1, coins, amount, dp);
    //     int pick = 0;
    //     if (coins[index]<=amount) {
    //         pick = f(index, coins, amount-coins[index], dp);
    //     }

    //     return dp[index][amount] = pick+notPick;
    // }
}
