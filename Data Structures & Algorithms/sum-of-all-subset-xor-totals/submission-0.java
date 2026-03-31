class Solution {
    int result = 0;
    public int subsetXORSum(int[] nums) {
        getSubsets(nums, 0, 0);
        return result;
    }
    private void getSubsets(int[] nums, int index, int sum) {
        if (index == nums.length) {
            result += sum;
            return;
        }
        // pick
        getSubsets(nums, index+1, sum^nums[index]);
        // not pick
        getSubsets(nums, index+1, sum);

    }
}