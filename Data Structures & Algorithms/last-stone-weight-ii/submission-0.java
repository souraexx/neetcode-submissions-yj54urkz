class Solution {
    public int lastStoneWeightII(int[] stones) {
        /* 
        find 2 subsets and its min difference
        totalSum = s1+s2
        we find Subset sum on totalSum 
        and then we find the min

        s1 = totalSum - s2
        | s1-s2 | min needs to be returned
        | totalSum - s2-s2 |
        | totalSum - 2*s2 |
        */ 
        int n = stones.length;
        int sum = 0;

        for (int stone: stones) {
            sum+= stone;
        }

        int dp[][] = new int[n][sum+1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int min = (int)1e9;
        // scanning the last row
        for (int i=0;i<=sum/2;i++) {
           if (subsetSum(n - 1, stones, i, dp)) {
                int s1 = i;
                int s2 = sum-s1;
                min = Math.min(min, Math.abs(s2-s1));
            }
        }

        if (min!=(int)1e9) {
            return min;
        } else {
            return 0;
        }

    }
    boolean subsetSum(int index, int stones[], int sum, int dp[][]) {

        if (sum==0) return true;
        if (index==0) {
            return (stones[0] == sum);
        } 

        if (dp[index][sum]!=-1) return dp[index][sum] == 1;
        boolean notPick = subsetSum(index-1, stones, sum, dp);
        boolean pick = false;
        if (stones[index] <= sum) {
            pick = subsetSum(index-1, stones, sum-stones[index], dp);
        }

        dp[index][sum] = (pick||notPick) ? 1:0;

        return pick || notPick;
    }
}