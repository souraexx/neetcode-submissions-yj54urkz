class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int minCost = (int)1e9;
        int prev2 = cost[0];
        int prev1 = cost[1];
        for(int i=2;i<cost.length;i++) {
            int curr = cost[i]+Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1, prev2);
    }
    // int minCost(int[] cost, int index) {
    //     if (index == 0) return cost[0];
    //     if (index == 1) return cost[1];
    //     int left = cost[index] + minCost(cost, index-1);
    //     int right = cost[index] + minCost(cost, index-2);
    //     return Math.min(left, right);
    // }
}
