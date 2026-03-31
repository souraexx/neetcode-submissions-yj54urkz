class Solution {
    public int subarraySum(int[] nums, int k) {
        int count =0;
        int prefixSum =0;
        Map<Integer,Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0,1);
        for (int num:nums) {
            prefixSum+= num;
            int diff = prefixSum - k;
            if (prefixSumMap.containsKey(diff)) {
                count=count +prefixSumMap.get(diff);
            } 
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum,0)+1);
        } 
        return count;
    }
}