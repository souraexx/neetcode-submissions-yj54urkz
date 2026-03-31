class Solution {
    public List<Integer> majorityElement(int[] nums) {
       List<Integer> result = new ArrayList<>();
        if (nums.length <= 2) {
            result.add(nums[0]);
            if (nums.length==2)
            result.add(nums[1]);
            return result;
        }
       int countOne = 0;
       int elementOne = 0;
       int countTwo = 0;
       int elementTwo = 0;
       for (int i =0;i<nums.length;i++) {
            if (nums[i]==elementOne) {
                countOne++;
            } else if (countOne==0 && nums[i]!=elementTwo) {
                countOne = 1;
                elementOne = nums[i];
            } else if (nums[i]==elementTwo) {
                countTwo++;
            } else if (countTwo ==0 && nums[i]!=elementOne) {
                countTwo = 1;
                elementTwo = nums[i];
            } else {
                countOne--;
                countTwo--;
            }
       }
       countOne = 0;
       countTwo = 0;
       for (int num:nums) {
        if (num == elementOne) {
            countOne++;
        } else if (num ==elementTwo) {
            countTwo++;
        }
       }
       System.out.print(elementOne);
       if (elementOne!=elementTwo)  {
        if (countOne>nums.length/3)
        result.add(elementOne);
        if (countTwo>nums.length/3)
        result.add(elementTwo);
       } else {
        result.add(elementOne);
       }
       return result;
    }
}
