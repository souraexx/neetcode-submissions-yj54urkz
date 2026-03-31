class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int left, right = 0;
        for (right = 0; right<nums.length; right++ ) {
            int tempMax = Integer.MIN_VALUE;
            for (left = right ; left < nums.length && left<right +k; left++) {
                if (nums[left] > tempMax) {
                    tempMax = nums[left];
                }
            }
            result.add(tempMax);
            if (right+ k == nums.length) 
                break;
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }  
        return arr;      
    }
}
