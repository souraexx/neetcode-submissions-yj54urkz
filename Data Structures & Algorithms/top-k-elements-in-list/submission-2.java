class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        if (k == nums.length)
            return nums;

        Map<Integer, Integer> mapFreq = new HashMap<>();
        for (int num: nums){
            mapFreq.put(num, mapFreq.getOrDefault(num, 0)+1);
        }

        List<Integer>[] bucketArray = new ArrayList[nums.length+1];
        for (int key: mapFreq.keySet()) {
            int value = mapFreq.get(key);
            if (bucketArray[value]==null) {
                bucketArray[value] = new ArrayList<>();
            }
            bucketArray[value].add(key);
            System.out.println(bucketArray[value]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = bucketArray.length -1; i>=0;i--) {
            if (bucketArray[i]!=null) {
                result.addAll(bucketArray[i]);
            }
        }
        
        return result.subList(0,k).stream().mapToInt(i->i).toArray();
    }
}

// 1,1 2,2 3,3 
