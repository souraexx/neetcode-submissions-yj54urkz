class Solution {
    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;
        int dp[] = new int[n+1];
        

        for (int i=n-1;i>=0;i--) {
            int sum = 0;
            int bestTurn = Integer.MIN_VALUE;

            for (int k=0;k<3 && i+k<n;k++) {
                sum+= stoneValue[i+k];
                int otherTurnDiff = sum - dp[i+k+1];
                bestTurn = Math.max(otherTurnDiff, bestTurn);
            }

            dp[i] = bestTurn;
        }

        int result = dp[0];

        if (result>1) return "Alice";
        else if (result==0) return "Tie";
        else return "Bob";

    }

    // Recursion
    int dfs(int stones[], int i, int dp[]) {
        int n = stones.length;
        if (i>=n) return 0;

        if (dp[i]!=(int)1e9) return dp[i];

        int sum = 0;
        int bestTurn = Integer.MIN_VALUE;
        for (int k=0;k<3 && i+k<stones.length ;k++) {
            sum+= stones[i+k];
            
            int otherTurnDiff = sum - dfs(stones, i+k+1, dp);
            bestTurn = Math.max(otherTurnDiff, bestTurn);
        }

        return dp[i] = bestTurn;
        
    }
}