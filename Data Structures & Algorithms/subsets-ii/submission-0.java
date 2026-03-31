class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        getComb(nums, 0, new ArrayList<>(), result);
        return result;
    }
    private void getComb(int[]nums, int index, List<Integer> ds, List<List<Integer>> result) {
        result.add(new ArrayList<>(ds));
        for (int i=index; i<nums.length; i++) {
            if (i>index && nums[i]==nums[i-1]) {
                continue;
            }
            //pick
            ds.add(nums[i]);
            getComb(nums, i+1, ds, result);
            //not pick
            ds.remove(ds.size()-1);
        }
    }
}
