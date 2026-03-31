class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyingPrice = prices[0];
        for (int i = 1 ; i<prices.length; i++) {
            int currentProfit = prices[i] - buyingPrice;
            profit = Math.max(profit, currentProfit);
            buyingPrice = Math.min(buyingPrice, prices[i]);
            System.out.println(i + " " + buyingPrice + " " + profit);
        }
        return profit;
    }
}
// 5,1,5,6,7,1,10
// 5 4 3 10