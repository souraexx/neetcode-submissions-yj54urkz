class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> hashingMap = new HashMap<>();
        for (int num : nums) {
            hashingMap.put(num, hashingMap.getOrDefault(num, 0)+1);
            if (hashingMap.get(num) > 1)
                return true;
        }
        return false;
    }
}