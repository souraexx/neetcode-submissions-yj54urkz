class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueElements = new HashSet<>();
        int maxSize = 0;
        for (int num: nums) {
            uniqueElements.add(num);
        }

        for (int num: uniqueElements) {
            if (!uniqueElements.contains(num-1)) {
                int len = 1;
                while(uniqueElements.contains(num+1)) {
                    len++;
                    num++;
                }
            maxSize = Math.max(len, maxSize);
            }
        }

        return maxSize;
    }
}
