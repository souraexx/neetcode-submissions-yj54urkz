class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueElements = new HashSet<>();
        int maxSize = 0;
        for (int num: nums) {
            uniqueElements.add(num);
        }

        for (int num: uniqueElements) {
            //System.out.print(num+" ");
            int len = 0;
            if (uniqueElements.contains(num-1)) {
                continue;
            }
            while(uniqueElements.contains(num)) {
                //System.out.print(num+" ");
                len++;
                num++;
            }
            //System.out.print("length -"+len);
            maxSize = Math.max(len, maxSize);
            System.out.print("length -"+maxSize);
        }

        return maxSize;
    }
}
