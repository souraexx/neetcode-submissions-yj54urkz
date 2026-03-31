class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        Arrays.sort(nums);
        getPerm(nums, used, new ArrayList<>(), result);
        return result;
    }
    private void getPerm(int[]nums, boolean used[], List<Integer> ds, List<List<Integer>> result) {
        if (ds.size() == nums.length) {
            result.add(new ArrayList<>(ds));
            return;
        }
        for (int i=0; i<nums.length; i++) {
            if (used[i]) continue;
            if ((i>0) && (nums[i]==nums[i-1]) && !used[i-1]) continue;

            //pick
            used[i] = true;
            ds.add(nums[i]);

            getPerm(nums, used, ds, result);

            // not pick
            used[i] = false;
            ds.remove(ds.size()-1);
        }
    }
}
