class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int pse[] = new int[n];
        int nse[] = new int[n];
        pse = calculatePSE(heights);
        nse = calculateNSE(heights);
        int maxArea=0;
        for (int i=0; i<n; i++) {
            int area = heights[i] * (nse[i]-pse[i]-1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
    private int[] calculatePSE(int[] heights) {
        int n = heights.length;
        int pseArr[] = new int[n];
        Stack<Integer> pse = new Stack<>();
        for (int i=0; i<n; i++) {

            while(!pse.isEmpty() && heights[pse.peek()]>=heights[i]) {
                pse.pop();
            }
            pseArr[i] = pse.isEmpty()?-1:pse.peek();
            pse.push(i);
        }
        return pseArr;
    }
    private int[] calculateNSE(int[] heights) {
        int n = heights.length;
        int nseArr[] = new int[n];
        Stack<Integer> nse = new Stack<>();
        for (int i=n-1; i>=0; i--) {

            while(!nse.isEmpty() && heights[nse.peek()]>=heights[i]) {
                nse.pop();
            }
            nseArr[i] = nse.isEmpty()?n:nse.peek();
            nse.push(i);
        }
        return nseArr;
    }
}
