class Solution {
    public int firstMissingPositive(int[] nums) {
        int containsOne = 0;
        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (nums[i] == 1) {
                containsOne = 1;
            }
            if (nums[i]<=0 || nums[i]>n) {
                nums[i] = 1;
            }
        }
        if (containsOne == 1) {
            for (int i=0; i<n; i++) {
                int idx = Math.abs(nums[i])-1;
                nums[idx] = Math.abs(nums[idx])*-1;
            }
            for (int i=0; i<n; i++) {
                if (nums[i]>0) {
                    return i+1;
                }
            }
            return n+1;
        }
        return 1;
    }
}