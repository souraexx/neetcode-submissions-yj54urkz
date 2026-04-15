class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int result = findCoins(n-1, coins, amount);
        if (result!=(int)1e9) {
            return result;
        } else {
            return -1;
        }
    }
    int findCoins(int index, int[] coins, int amount) {
        if (index == 0) {
            if (amount%coins[index] == 0) return amount/coins[index];
            else return (int)1e9;
        }

        int notPick = findCoins(index-1, coins, amount);
        int pick = (int)1e9;
        if (coins[index]<=amount) {
            pick =  1 + findCoins(index, coins, amount-coins[index]);
        }

        return Math.min(pick, notPick);
    }
}
