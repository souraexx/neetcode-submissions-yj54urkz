class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int ballons[] = new int[n+2];
        ballons[0] = 1; ballons[n+1] = 1;
        for (int i=1;i<=n;i++) {
            ballons[i] = nums[i-1];
        }

        int dp[][] = new int[n+2][n+2];
        
        for (int i=n;i>=1;i--) {
            for (int j=1;j<=n;j++) {
                if (i>j) continue;
                int sum = -(int)1e9;
                for (int ind=i; ind<=j; ind++) {
                    int coins = (ballons[i-1]*ballons[ind]*ballons[j+1]) +
                        dp[i][ind-1] + dp[ind+1][j];
                    sum = Math.max(sum, coins); 
                }
                dp[i][j] = sum;
            }
        }

        return dp[1][n];

    } 


    // Recursion
    int f(int i, int j, int[] ballons, int dp[][]) {
        if (i>j) return 0;

        if (dp[i][j]!=-1) return dp[i][j];

        int sum = Integer.MIN_VALUE;
        for (int ind=i; ind<=j; ind++) {
            int coins = (ballons[i-1]*ballons[ind]*ballons[j+1]) +
                        f(i, ind-1, ballons, dp) + f(ind+1, j, ballons, dp);
            sum = Math.max(sum, coins); 
        }

        return dp[i][j]=sum;
    }
}
