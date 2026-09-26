class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        int maxArea = x + Math.max(s, Math.max(m, l));
        int[] dp = new int[maxArea + 1];
        for (int i = 1; i <= maxArea; dp[i] = Integer.MAX_VALUE / 2, i++);

        for (int i = 1; i <= maxArea; i++) {
            if (i >= s) 
                dp[i] = Math.min(dp[i], dp[i - s] + cs);
            if (i >= m) 
                dp[i] = Math.min(dp[i], dp[i - m] + cm);
            if (i >= l) 
                dp[i] = Math.min(dp[i], dp[i - l] + cl);
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = x; i <= maxArea; minCost = Math.min(minCost, dp[i]), i++);

        return minCost;
    }
}