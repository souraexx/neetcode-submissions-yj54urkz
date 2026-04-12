class Solution {
    public boolean canPartition(int[] nums) {
        int sum = totalSum(nums);
        if (sum % 2 != 0) return false;
        
        return findSubsetSum(nums, nums.length, sum/2);
    }

    boolean findSubsetSum(int nums[], int n, int target) {
        boolean dp[][] = new boolean[n][target+1];

        for (int i=0;i<n;i++) {
            dp[i][0] = true;
        } 
        if (nums[0]<=target) dp[0][nums[0]] = true;

        for (int i=1;i<n;i++) {
            for (int j=1;j<=target;j++) {
                boolean pick = false;
                if (nums[i] <= j) {
                    pick = dp[i-1][j-nums[i]];
                }
                boolean notPick = dp[i-1][j];
                dp[i][j] = pick || notPick;
            }
        }
        return dp[n-1][target];
    }

    int totalSum(int nums[]) {
        int sum = 0;
        for (int num: nums) {
            sum+= num;
        }
        return sum;
    }

    // Rercursion

    // boolean findSubsetSum(int nums[], int index, int target) {
    //     if (target == 0) return true;
    //     if (index == 0) return (nums[0]==target);

    //     //take
    //     boolean take = false;
    //     if (nums[index] <= target) {
    //         take = findSubsetSum(nums, index-1, target-nums[index]);
    //     }
    //     // not take
    //     boolean notTake = findSubsetSum(nums, index-1, target);

    //     return take || notTake;
    // }

}
