class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int n = nums.length;
        int temp[] = new int[n-k];
        for(int i =0;i<n-k;i++) {
            temp[i]=nums[i];
        }
        for (int i =0;i<k;i++) {
            nums[i] = nums[i+(n-k)];
        }
        int index = 0;
        for (int i=k;i<n;i++) {
            nums[i] = temp[index++];
        }
    }
}
// 1 2 3 4 5 ; 2
// 4 5 1 2 3