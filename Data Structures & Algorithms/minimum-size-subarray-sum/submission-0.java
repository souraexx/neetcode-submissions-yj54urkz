class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int count = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right=0;right<nums.length;right++) {
            sum+= nums[right];
            while (sum>=target) {
                count = Math.min((right-left+1),count);
                sum-= nums[left];
                left++;
            }
        }
        if (count == Integer.MAX_VALUE) {
            return 0;
        }
        return count;
    }
}