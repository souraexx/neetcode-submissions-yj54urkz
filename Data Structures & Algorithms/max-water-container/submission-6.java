class Solution {
    public int maxArea(int[] heights) {
        int maxQuantity = 0;
        int left = 0;
        int right = heights.length-1;
        while (left < right) {
            int quantity = (right-left)*Math.min(heights[left],heights[right]);
            maxQuantity = Math.max(quantity, maxQuantity);
            if (heights[left]<heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxQuantity;
    }
}
