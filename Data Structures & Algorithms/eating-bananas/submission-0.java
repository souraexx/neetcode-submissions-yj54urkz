class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length-1;
        int high = getMax(piles);
        int low = 1;
        int ans = -1;
        while(low<=high) {
            int mid = (low+high)/2;
            if (checkHour(mid,piles) <= h) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    private int getMax(int piles[]) {
        int max = -1;
        for (int i=0;i<piles.length;i++) {
            if (piles[i]>max){
                max=piles[i];
            }
        }
        return max;
    }
    private int checkHour(int x, int arr[]){
        int hour=0;
        for (int i=0; i<arr.length; i++) {
            hour += Math.ceil((double)(arr[i])/(double)x);
        } 
        return hour;
    }
}
