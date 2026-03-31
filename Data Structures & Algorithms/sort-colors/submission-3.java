class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        int i = 0;
        while (mid<=high) {
            if (nums[mid] == 0) {
                nums[mid] = nums[low];
                nums[low] = 0;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                nums[low] = 1;
                mid++;
            } else {
                nums[mid] = nums[high];
                nums[high] = 2;
                high--;
            }
        }
    }
}
/*
0 to low-1 = 0
low to mid -1 = 1
mid to high = unsorted
high + 1 to n = 2
*/