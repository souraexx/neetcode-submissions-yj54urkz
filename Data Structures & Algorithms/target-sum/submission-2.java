class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       return findWays(nums, target, nums.length-1, 0, 0);
    }
    int findWays(int[] nums, int target, int index, int sum, int count) {
        if (index == 0) {
            if (sum+nums[index] == target) {
                count++;
            }
            if (sum-nums[index] == target) {
                count++;
            }
            return count;
        }

        int copy = sum;

        // subtract
        sum -= nums[index];
        int subtractIndex = findWays(nums, target, index-1, sum, count);

        sum = copy;
        // add
        sum += nums[index];
        int addIndex = findWays(nums, target, index-1, sum, count);

        return subtractIndex + addIndex;
    }
}
