class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> prefixSum = new HashMap<>(); // prefixSum, index
        prefixSum.put(nums[0], 0);

        for (int num = 1 ; num<nums.length;num++) {
            int rem = target - nums[num];
            if (prefixSum.containsKey(rem)) {
                return new int[]{prefixSum.get(rem),num };
            }
            prefixSum.put(nums[num], num);
        }

        return new int[]{-1,-1};
    }
}
 // 3,0
 // rem = 3 
 // 4, 0
 // rem = 5 put 5,1
 // rem = 4 