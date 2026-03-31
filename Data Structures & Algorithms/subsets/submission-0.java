class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        getSubsets(nums, 0, result, ds);
        return result;
    }
    private void getSubsets(int[] nums, int index, List<List<Integer>> result, List<Integer> ds) {
        if (index == nums.length) {
            result.add(new ArrayList<>(ds));
            return;
        }
        // pick
        ds.add(nums[index]);
        getSubsets(nums, index+1, result, ds);
        // not pick
        ds.remove(ds.size()-1);
        getSubsets(nums, index+1, result, ds);

        return;
    }
}
