class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for (int row[]: dp) {
            Arrays.fill(row, -1);
        }
        return f(n-1, coins, amount, dp);
    }
    int f(int index, int coins[], int amount, int dp[][]) {

        if (index == 0) {
            if (amount%coins[0] == 0) return 1;
            return 0;
        }

        if (dp[index][amount]!=-1) return dp[index][amount];

        int notPick = f(index-1, coins, amount, dp);
        int pick = 0;
        if (coins[index]<=amount) {
            pick = f(index, coins, amount-coins[index], dp);
        }

        return dp[index][amount] = pick+notPick;
    }
}
