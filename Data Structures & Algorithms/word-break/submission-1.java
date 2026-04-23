class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        dp[n] = true;
        for (int i=s.length()-1;i>=0;i--) {
            boolean flag = false;
            for(int end = i+1;end<=s.length();end++) {
                String temp = s.substring(i, end);
                if (wordDict.contains(temp)) {
                    if (dp[end] == true) {
                        flag = true;
                    }
                }
            }
            dp[i] = flag;
        }
    
    return dp[0];
    }

    // Recursion

    boolean f(int start, String s, List<String> wordDict, int dp[]) {

        if (start==s.length()) return true;

        if (dp[start]!=-1) {
            if (dp[start] == 0)
              return false;
            else 
              return true;
        }
        int end = start+1;
        for (int i=end; i<=s.length(); i++) {
            String temp = s.substring(start, i);
            if (wordDict.contains(temp)) {
                if (f(i, s, wordDict, dp)) {
                    dp[start] = 1;   
                    return true;
                }
            }
        }

        dp[start] = 0;
        return false;
    }
}
