class Solution {
    public int longIncPath(int[][] matrix, int n, int m) {
        int[][] dp = new int[n][m];
        int maxLen = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; maxLen = Math.max(maxLen, dfs(matrix, i, j, n, m, dp)),j++);

        return maxLen;
    }

    private int dfs(int[][] matrix, int r, int c, int n, int m, int[][] dp) {
        if (dp[r][c] != 0)
            return dp[r][c];

        int max = 1;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && matrix[nr][nc] > matrix[r][c])
                max = Math.max(max, 1 + dfs(matrix, nr, nc, n, m, dp));
        }

        dp[r][c] = max;
        return max;
    }
}