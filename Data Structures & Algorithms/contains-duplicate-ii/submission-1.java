class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();
        int removeIndex = 0;
        for (int i =0;i<nums.length;i++) {
            if (window.contains(nums[i])) {
                return true;
            }
            window.add(nums[i]);
            if (window.size() > k) {
                window.remove(nums[removeIndex]);
                removeIndex++;
            }
        }
        return false;
    }
}