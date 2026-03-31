class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     if (nums1.length>nums2.length) {
        return findMedianSortedArrays(nums2, nums1);
     }   
     int m = nums1.length;
     int n = nums2.length;
     int leftHalf = (n+m+1)/2;
     int low = 0;
     int high = m;
     while(low<=high) {
        int mid = (low+high)/2;
        int mid2 = leftHalf - mid;
        int l1 = (mid==0) ? Integer.MIN_VALUE:nums1[mid-1];
        int r1 = (mid==m) ? Integer.MAX_VALUE:nums1[mid];
        int l2 = (mid2==0) ? Integer.MIN_VALUE:nums2[mid2-1];
        int r2 = (mid2==n) ? Integer.MAX_VALUE:nums2[mid2];
        if ((l1<=r2) && (l2<=r1)) {
            if ((m+n)%2 == 0) {
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else {
                return Math.max(l1,l2);
            }
        } else if (l1>r2) {
            high = mid-1;
        } else {
            low = mid+1;
        }
     }
     return -1;
    }
}
