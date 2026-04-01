class Solution {
    public int climbStairs(int n) {
        int prev = 1;
        int prev2 = 0;
        for (int i=1;i<=n;i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    // int getClimbStairs(int index, int dp[]) {
    //     if (index==0) return 1;
    //     if (index==1) return 1;
    //     if (dp[index] != -1) return dp[index];
    //     int left = getClimbStairs(index-1, dp);
    //     int right = getClimbStairs(index-2, dp);
    //     return dp[index] = left+right;
    // }
}
