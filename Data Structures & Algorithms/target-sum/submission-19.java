class Solution {
    /*
    Target = subset of add - subset of subtract
    so, D = S1-s2 (S1+S2 = Total sum)
    D = TotalSum - S2 -S2
    2*S2 = TotalSum - D
    S2 = (TotalSum-D)/2
    So I have to look for S2 only
    */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num:nums) {
            sum += num;
        }

        int n = nums.length;
        int s = sum-target;

        if (s<0 || s%2==1) return 0;
        int s2 = s/2;

        int dp[][] = new int[n][s2+1];

        if (nums[0]==0) {
            dp[0][0] = 2;
        }
        else {
            dp[0][0] = 1;
            if (nums[0]<=s2) {
                dp[0][nums[0]] = 1;
            }
        }
        for (int i=1; i<n;i++) {
            for (int j=0;j<=s2;j++) {
                int notPick = dp[i-1][j];
                int pick = 0;
                if (nums[i]<=j) {
                    pick = dp[i-1][j-nums[i]];
                }
                dp[i][j] = pick+notPick;
            }
        }
        return dp[n-1][s2];
    }


    // Recursion

    // int findSubsetSum(int index, int nums[], int target, int dp[][]) {
    //     if (index==0) {
    //         if (nums[0]==0 && target==0) return 2;
    //         if (nums[0]==target || target==0) return 1;
    //         return 0;
    //     }
        
    //     if (dp[index][target] != -1) return dp[index][target];

    //     int notPick = findSubsetSum(index-1, nums, target, dp);
    //     int pick = 0;
    //     if (nums[index] <= target) {
    //         pick = findSubsetSum(index-1, nums, target-nums[index], dp);
    //     }

    //     return dp[index][target] = pick+notPick;
        
    // }
}
