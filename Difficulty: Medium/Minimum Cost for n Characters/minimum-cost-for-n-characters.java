class Solution {
    public int minCost(int n, int i, int d, int c) {
        if (n <= 0)
            return 0;
        if (n == 1) 
            return i;

        int[] dp = new int[n + 1];
        dp[1] = i;

        for (int k = 2; k <= n; dp[k] = (k % 2 == 0)? Math.min(dp[k - 1] + i, dp[k / 2] + c) : Math.min(dp[k - 1] + i, dp[(k + 1) / 2] + c + d), k++);

        return dp[n];
    }
}