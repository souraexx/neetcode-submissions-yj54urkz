class Solution {
    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;
        int dp[] = new int[n];
        Arrays.fill(dp, (int)1e9);
        
        int result = dfs(stoneValue, 0, dp);

        if (result>1) return "Alice";
        else if (result==0) return "Tie";
        else return "Bob";

    }
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