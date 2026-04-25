class Solution {
    public int maxProfit(int[] prices) {
        
        //int dp[][] = new int[prices.length+2][2]; 
        
        // index, buy/sell (buy is 1)

        int next2[] = new int[2];
        int next1[] = new int[2];

        for (int i=prices.length-1;i>=0;i--) {

            int cur[] = new int[2];

            // buy
            cur[1] = Math.max(-prices[i]+next1[0], next1[1]);

            // sell
            cur[0] = Math.max(prices[i]+next2[1], next1[0]);

            next2 = next1;
            next1 = cur;

        }

        return next1[1];
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
