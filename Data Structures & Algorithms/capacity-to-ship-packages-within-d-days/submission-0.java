class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = getMax(weights);
        int high = getSum(weights);
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if (calcDays(weights, mid)<=days) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    private int getMax(int arr[]) {
        int max = -1;
        for(int i=0; i<arr.length; i++) {
            if (arr[i]>max) {
                max = arr[i];
            }
        }
        return max;
    }
    private int getSum(int arr[]) {
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum+= arr[i];
        }
        return sum;
    }
    private int calcDays(int arr[], int x) {
        int days =0;
        int sum =0;
        for (int i=0; i<arr.length; i++) {
            if (sum+arr[i] > x) {
                days++;
                sum = 0;
            }
            sum += arr[i];
        }
        if (sum>0) {
            days++;
        }
        return days;
    }
}