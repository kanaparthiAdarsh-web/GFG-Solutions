class Solution {
    public int findMinCost(String s1, String s2, int costS1, int costS2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; dp[i][j] = (s1.charAt(i - 1) == s2.charAt(j - 1))? 1 + dp[i - 1][j - 1] : Math.max(dp[i - 1][j], dp[i][j - 1])
, j++); 
                
        int lcs = dp[m][n];
        return (m - lcs) * costS1 + (n - lcs) * costS2;
    }
}