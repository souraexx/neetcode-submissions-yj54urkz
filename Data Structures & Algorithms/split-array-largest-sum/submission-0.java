class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        if (k > n) {
            return -1;
        }

        int low = -1;
        int high = 0;
        int ans = 0;

        for (int num:nums) {
            if (num>low) {
                low = num;
            }
            high += num;
        }
        
        while(low<=high) {
            int mid = (low+high)/2;
            if (countSubArraysWithMid(mid,nums) <= k) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return ans;
    }
    private int countSubArraysWithMid(int mid, int nums[]) {
        int count = 0;
        int sum = nums[0];
        for (int i=1;i<nums.length;i++) {
            sum+= nums[i];
            if (sum > mid) {
                count++;
                sum=nums[i];
            }
        }
        if (sum>0) count++;
        return count;
    }
}
// 10 - 40
// 25