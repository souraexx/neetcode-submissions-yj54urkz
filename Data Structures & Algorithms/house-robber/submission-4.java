class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int prev2 = nums[0]; // at i-2 whats the highest adjacent sum
        int prev1 = Math.max(nums[0], nums[1]); // at i-1 whats the highest adjacent sum
        for (int i=2;i<nums.length;i++) {
            int element = nums[i];
            // pick
            int pick = element + prev2;
            // not pick
            int notPick = 0 + prev1;

            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
