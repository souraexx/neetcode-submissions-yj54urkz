class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length+2][2]; // index, buy/sell (buy is 1)

        for (int i=prices.length-1;i>=0;i--) {
            for (int j=0;j<=1;j++) {
                    int profit = 0;

                    if (j==1) {
                        profit = Math.max((-prices[i] + dp[i+1][0]) , 
                                dp[i+1][1]);
                    } else {
                        profit = Math.max((prices[i]+dp[i+2][1]) ,
                                dp[i+1][0]);
                    }

                dp[i][j] = profit;
            }
        }

        return dp[0][1];
    }

    // Recursion

    int f (int index, int prices[], int buy, int dp[][]) {

        if (index>=prices.length) return 0;

        if (dp[index][buy] != -1) return dp[index][buy];

        int profit = 0;
        if (buy==1) {
            profit = Math.max((-prices[index] + f(index+1, prices, 0, dp)) , 
                                f(index+1, prices, 1, dp));
        } else {
            profit = Math.max((prices[index]+f(index+2, prices, 1, dp)) ,
                                f(index+1, prices, 0, dp));
        }

        return dp[index][buy] = profit;
    }
}
