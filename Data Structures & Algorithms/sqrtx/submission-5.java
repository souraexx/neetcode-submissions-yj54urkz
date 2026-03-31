class Solution {
    public int mySqrt(int x) {
        if (x==0) return 0;
        if (x==1) return 1;
        int low = 1;
        int high = x/2;
        int ans=0;
        while (low<=high) {
            int mid = low + (high-low)/2;
            long pow = (long) mid * mid;
            if (pow <= x) {
                ans=mid;
                low=mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
}