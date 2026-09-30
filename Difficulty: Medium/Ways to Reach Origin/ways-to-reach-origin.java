class Solution {
    public int ways(int x, int y) {
        int mod = 1000000007;
        int[][] dp = new int[x + 1][y + 1];

        for (int i = 0; i <= x; dp[i][0] = 1,i++);
            
        for (int j = 0; j <= y; dp[0][j] = 1,j++);

        for (int i = 1; i <= x; i++) 
            for (int j = 1; j <= y; dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod,j++);
            

        return dp[x][y];
    }
}