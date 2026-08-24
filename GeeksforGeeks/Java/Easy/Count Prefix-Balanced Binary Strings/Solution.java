class Solution {
    private static final int MAX = 1001;
    private static final long MOD = 1000000007L;
    private static final long[] dp = new long[MAX];
    private static boolean computed = false;

    private static void precompute() {
        dp[0] = 1;
        for (int i = 1; i < MAX; i++)
            for (int j = 0; j < i;dp[i] = (dp[i] + (dp[j] * dp[i - 1 - j]) % MOD) % MOD,j++);
        computed = true;
    }

    public int prefixStrings(int n) {
        if (!computed)
            precompute();
        
        return (int) dp[n];
    }
}