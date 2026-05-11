class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        
        for(int i=1; i<nums.length; i++) {

            int num = nums[i];
            
            int curMax = Math.max(num, Math.max(num*max, num*min));
            int curMin = Math.min(num, Math.min(num*min, num*max));

            max = curMax;
            min = curMin;

            ans = Math.max(ans, max);

        }

        return ans;
    }
}
