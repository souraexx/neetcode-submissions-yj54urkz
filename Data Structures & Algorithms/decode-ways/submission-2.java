class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int dp[] = new int[n+1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }

        for (int i=2;i<=n;i++) {

            int ways = 0;
            // 1 digit
            if (s.charAt(i-1)!= '0')
                ways = dp[i-1];

            // 2 digit
            int num = Integer.parseInt(s.substring(i-2, i));
            if (num>=10 && num<=26) {
                ways+=  dp[i-2];
            }
            dp[i] = ways;
        }
        return dp[n];
    }

    // Recursion
    int f(String s, int i) {
        if (i == 0) return 1;

        if (s.charAt(i-1) == '0') return 0;

        int ways = 0;
        // 1 digit
        ways = f(s, i-1);

        // 2 digit
        if (i>=2) {
            int num = Integer.parseInt(s.substring(i-2, i));
            if (num>=10 && num<=26) {
                ways+=  f(s, i-2);
            }
        }

        return ways;
    }
}
