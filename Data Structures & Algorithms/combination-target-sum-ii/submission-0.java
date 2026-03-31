class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        getComb(0, candidates, target, new ArrayList<>(), result);
        return result;
    }
    private void getComb(int index, int nums[], int target, List<Integer> ds, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int i=index; i<nums.length; i++) {
            if (i>index && nums[i]==nums[i-1]) {
                continue;
            }

            if (nums[i] > target) break;
            // pick
            ds.add(nums[i]);
            getComb(i+1, nums, target-nums[i], ds, result);
            // not pick
            ds.remove(ds.size()-1);
        }
    }
}
