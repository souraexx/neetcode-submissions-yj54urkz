class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        reverse(nums);

        int sides[] = new int[k];

        int sum = 0;
        for (int i =0;i<nums.length; i++) {
            sum+= nums[i];
        }
        if (sum%k != 0) return false;
        if (nums[0] > sum/k) return false;

        return getSquare(nums, 0, sides, sum/k, k);
    }

    private Boolean getSquare(int[] matchsticks, int index, int[] sides, int target, int k) {
        if (index == matchsticks.length) {
            for (int i =0; i<k; i++) {
                if (sides[i]!=target) return false;
            }
            return true;
        }

        int stick = matchsticks[index];
        for (int i = 0; i<k; i++) {
            if (stick + sides[i] > target) continue;

            sides[i]+= stick;
            if (getSquare(matchsticks, index+1, sides, target, k)) return true;
            sides[i]-= stick;

            if (sides[i] == 0) break;
        }
        return false;
    }
    private void reverse(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start<end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}