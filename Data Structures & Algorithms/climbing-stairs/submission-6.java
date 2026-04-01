class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return getClimbStairs(n, dp);
    }
    int getClimbStairs(int index, int dp[]) {
        if (index==0) return 1;
        if (dp[index] != -1) return dp[index];
        int left = getClimbStairs(index-1, dp);
        int right = 0;
        if (index>1) {
            right = getClimbStairs(index-2, dp);
        }
        return dp[index] = left+right;
    }
}
