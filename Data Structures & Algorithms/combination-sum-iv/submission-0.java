class Solution {
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target+1];
        dp[0] = 1;
        for (int i=1;i<=target;i++) {
            int count = 0;
            for (int num: nums) {
                if (i-num>=0) {
                    count += dp[i-num];
                }
            }
            dp[i] = count;
        }

        return dp[target];
    }

    // Recursion
    int f(int nums[], int target , int dp[]) {

        if (target == 0) return 1;
        if (target<0) return 0;

        if (dp[target]!=-1) return dp[target];

        int count = 0;
        for (int num: nums) {
            count+= f(nums, target-num, dp);
        }
        return dp[target] = count;
    }
}