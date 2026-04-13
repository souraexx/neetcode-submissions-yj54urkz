class Solution {
    public boolean canPartition(int[] nums) {
        int sum = totalSum(nums);
        if (sum % 2 != 0) return false;
        
        return findSubsetSum(nums, nums.length, sum/2);
    }

    boolean findSubsetSum(int nums[], int n, int target) {
        boolean prev[] = new boolean[target+1];

        prev[0] = true;
        if (nums[0]<=target) prev[nums[0]] = true;

        for (int i=1;i<n;i++) {
            boolean curr[] = new boolean[target+1];
            curr[0] = true;
            for (int j=1;j<=target;j++) {
                boolean pick = false;
                if (nums[i] <= j) {
                    pick = prev[j-nums[i]];
                }
                boolean notPick = prev[j];
                curr[j] = pick || notPick;
            }
            prev = curr;
        }
        return prev[target];
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
