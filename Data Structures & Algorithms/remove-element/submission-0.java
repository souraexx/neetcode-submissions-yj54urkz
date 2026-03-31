class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        List<Integer> notVal = new ArrayList<>();
        for (int num:nums) {
            if (num != val) {
                notVal.add(num);
                count++;
            }
        }
        for (int i = 0;i<notVal.size();i++) {
            nums[i] = notVal.get(i);
        }
        for (int i = notVal.size();i<nums.length;i++) {
            nums[i] = val;
        }
        return count;
    }
}