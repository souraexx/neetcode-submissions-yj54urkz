class Solution {
    public int[] productExceptSelf(int[] nums) {

        int result[] = new int[nums.length];

        int prefixPrdt = 1;
        int suffixPrdt = 1;
        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefixPrdt = prefixPrdt * nums[i-1];
            result[i] = prefixPrdt;
        }

        for (int i = nums.length-1; i>=0; i--) {
            result[i] = result[i]*suffixPrdt;
            suffixPrdt = suffixPrdt * nums[i];
        }

        return result;
    }
}  

/* 
1 2 4 6
prefixPrdt = 2 
1 2 4 6
1 0 0 0
1 1 0 0
1 1 2 0
1 1 2 8

suffixPrdt = 28
1 2 4 6
1 1 2 8
1 1 12 8
1 24 12 8
48 24 12 8

prefixPrdt = 2
2 3 5 0
1 0 0 0
1 2 0 0
1 2 6 0

*/