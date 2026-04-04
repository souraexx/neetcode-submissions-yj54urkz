class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];
        if (n==2) return Math.max(nums[0], nums[1]);
        //since its a circle, we have to find max adjacent sum including start to end-1 or start+1 to end
        int notIncludeStart = adjacentSum(nums, 1, n);
        int notIncludeEnd = adjacentSum(nums, 0, n-1);
        return Math.max(notIncludeStart, notIncludeEnd);
    }
    private int adjacentSum(int []nums, int start, int end) {
        int prev2 = nums[start];
        int prev1 = Math.max(nums[start+1], nums[start]);
        for (int i=start+2;i<end;i++) {
            int pick = nums[i] + prev2;
            int notPick = 0 + prev1;
            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
