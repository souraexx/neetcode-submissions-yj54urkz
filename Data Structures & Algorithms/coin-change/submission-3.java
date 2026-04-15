class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for (int row[]: dp) {
            Arrays.fill(row, -1);
        }
        int result = findCoins(n-1, coins, amount, dp);
        if (result!=(int)1e9) {
            return result;
        } else {
            return -1;
        }
    }
    int findCoins(int index, int[] coins, int amount, int dp[][]) {
        if (index == 0) {
            if (amount%coins[index] == 0) return amount/coins[index];
            else return (int)1e9;
        }

        if (dp[index][amount]!=-1) return dp[index][amount];

        int notPick = findCoins(index-1, coins, amount, dp);
        int pick = (int)1e9;
        if (coins[index]<=amount) {
            pick =  1 + findCoins(index, coins, amount-coins[index], dp);
        }

        return dp[index][amount] = Math.min(pick, notPick);
    }
}
