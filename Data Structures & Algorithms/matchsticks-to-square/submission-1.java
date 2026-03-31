class Solution {
    public boolean makesquare(int[] matchsticks) {

        Arrays.sort(matchsticks);
        reverse(matchsticks);

        int sides[] = new int[4];

        int sum = 0;
        for (int i =0;i<matchsticks.length; i++) {
            sum+= matchsticks[i];
        }
        if (sum%4 != 0) return false;

        return getSquare(matchsticks, 0, sides, sum/4);
    }

    private Boolean getSquare(int[] matchsticks, int index, int[] sides, int target) {
        if (index == matchsticks.length) {
            return sides[0] == target  && sides[1] == target && sides[2] == target && sides[3] == target;
        }

        int stick = matchsticks[index];
        for (int i = 0; i<4; i++) {
            if (stick + sides[i] > target) continue;

            sides[i]+= stick;
            if (getSquare(matchsticks, index+1, sides, target)) return true;
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