class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = -1;
        int rightMax = -1;
        int water = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                    left++;
                } else {
                    water += leftMax - height[left];
                    left++;
                }
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                    right--;
                } else {
                    water += rightMax - height[right];
                    right--;
                }
            }
        }

        return water;   
    }
}
/* 0 2 0 3 1 0 1 3 2 1
0. leftMax = 0;
    left = 1;
1. rightMax = 1;
    right = n - 2;
3. 
*/