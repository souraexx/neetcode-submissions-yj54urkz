class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for (int i=0;i<=amount;i++) {
            if (i%coins[0] == 0) {
                dp[0][i] = i/coins[0];
            } else {
                dp[0][i] = (int)1e9;
            } 
        } 

        for (int i=1;i<n;i++) {
            for (int j=0;j<=amount;j++) {
                int notPick = dp[i-1][j];
                int pick = (int) 1e9;
                if (coins[i]<=j) {
                    pick = 1 + dp[i][j-coins[i]];
                }
                dp[i][j] = Math.min(pick, notPick);
            }
        }

        int result = dp[n-1][amount];
        if (result!=(int)1e9) return result;
        else return -1;
    }


    // Recursion

    // int findCoins(int index, int[] coins, int amount, int dp[][]) {
    //     if (index == 0) {
    //         if (amount%coins[index] == 0) return amount/coins[index];
    //         else return (int)1e9;
    //     }

    //     if (dp[index][amount]!=-1) return dp[index][amount];

    //     int notPick = findCoins(index-1, coins, amount, dp);
    //     int pick = (int)1e9;
    //     if (coins[index]<=amount) {
    //         pick =  1 + findCoins(index, coins, amount-coins[index], dp);
    //     }

    //     return dp[index][amount] = Math.min(pick, notPick);
    // }
}
