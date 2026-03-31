class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums,0,n-1);
        reverse(nums,0, k-1);
        reverse(nums,k, n-1);
    }
    private void reverse(int[] nums,int start,int end) {
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
// 1 2 3 4 5 ; 2
// 5 4 3 2 1
// 4 5 1 2 3