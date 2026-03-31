class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getComb(0, nums, target, new ArrayList<>(), result);
        return result;
    }
    private void getComb(int index, int[]nums, int target, List<Integer> ds, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }
        if (target < 0 || index==nums.length) {
            return;
        }

        int element = nums[index];
        //pick
        ds.add(element);
        getComb(index, nums, target-element, ds, result);

        //not pick
        ds.remove(ds.size()-1);
        getComb(index+1, nums, target, ds, result);
    }
}
