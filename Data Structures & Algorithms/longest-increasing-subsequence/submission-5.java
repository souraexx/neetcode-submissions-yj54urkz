class Solution {
    public int lengthOfLIS(int[] nums) {
        // using Binary Search
        int n = nums.length;
        List<Integer> lis = new ArrayList<>();
        for (int num: nums) {
            int low = 0;
            int high = lis.size()-1;
            int pos = lis.size();
            while (low<=high) {
                int mid = low + (high-low) /2;
                if (lis.get(mid)>=num) {
                    pos = mid;
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }

            if (pos==lis.size()) {
                lis.add(num);
            } else {
                lis.set(pos, num);
            }
        }

        return lis.size();
    }

    // DP algorithm
    int algorithm (int nums[]) {
        
        int n = nums.length;
        int maxLen = 0;
        int dp[] = new int[n];
        for (int i=0;i<n;i++) {
            dp[i] = 1;
            for (int prev=0;prev<i;prev++) {
                if (nums[i]>nums[prev] && dp[prev]+1>dp[i]) {
                    dp[i] = dp[prev]+1;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }


    // Tabulation with coordinate shift
    
    int tabulation(int nums[]) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for (int i=n-1;i>=0;i--) {
            for (int j=i-1;j>=-1;j--) {

                // not take
                int length = dp[i+1][j+1];
                // take
                if (j==-1 || nums[i] > nums[j])
                    length = Math.max(length, 1+dp[i+1][i+1]);

                dp[i][j+1] = length;
            }
        }
        return dp[0][0];
    }

    // Recursion

    int f(int nums[], int index, int prevIndex, int dp[][]) {

        if (index==nums.length) return 0;

        if (dp[index][prevIndex+1] != -1) return dp[index][prevIndex+1];

        // not take
        int length = f(nums, index+1, prevIndex, dp);

        // take
        if (prevIndex==-1 || nums[index]>nums[prevIndex]) {
            length = Math.max(length, 1+f(nums, index+1, index, dp));
        }

        return dp[index][prevIndex+1] = length;
    }
}
