class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> pse = new Stack<>();
        int maxArea = 0;
        for (int i=0; i<n; i++) {

            while(!pse.isEmpty() && heights[pse.peek()]>=heights[i]) {
                int element = pse.pop();
                int currPse = pse.isEmpty()?-1:pse.peek();
                int currNse = i;
                int area = heights[element] * (currNse-currPse-1);
                maxArea = Math.max(area, maxArea);
            }
            pse.push(i);

        }

        while(!pse.isEmpty()) {
                int element = pse.pop();
                int currPse = pse.isEmpty()?-1:pse.peek();
                int currNse = n;
                int area = heights[element] * (currNse-currPse-1);
                maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}
