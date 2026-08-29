class Solution {
    public int countSubsequences(String s, int n) {
        long mod = 1000000007L;
        long[] dp = new long[n];
        int len = s.length();

        for (int i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';
            long[] nextDp = new long[n];

            for (int r = 0; r < n; r++)
                nextDp[r] = dp[r];

            nextDp[digit % n] = (nextDp[digit % n] + 1) % mod;

            for (int r = 0; r < n; r++)
                if (dp[r] > 0) {
                    int nextRem = (r * 10 + digit) % n;
                    nextDp[nextRem] = (nextDp[nextRem] + dp[r]) % mod;
                }

            dp = nextDp;
        }

        return (int) dp[0];
    }
}