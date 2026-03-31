class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getPerm(nums, 0, result);
        return result;
    }
    private void getPerm(int[]nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i<nums.length; i++) {
                ds.add(nums[i]);
            }
            result.add(new ArrayList<>(ds));
            return;
        }
        for (int i=index; i<nums.length; i++) {
            // swap
            int t = nums[index];
            nums[index] = nums[i];
            nums[i] = t;

            getPerm(nums, index+1, result);

            // swap
            t = nums[index];
            nums[index] = nums[i];
            nums[i] = t;
        }
    }
}
