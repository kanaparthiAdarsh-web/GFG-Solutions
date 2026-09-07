class Solution {
    private int[][][] dp;

    private int solve(int i, int incIdx, int decIdx, int[] arr, int n) {
        if (i == n)
            return 0;

        if (dp[i][incIdx + 1][decIdx + 1] != -1)
            return dp[i][incIdx + 1][decIdx + 1];

        int ans = solve(i + 1, incIdx, decIdx, arr, n);

        if (incIdx == -1 || arr[i] > arr[incIdx])
            ans = Math.max(ans, 1 + solve(i + 1, i, decIdx, arr, n));

        if (decIdx == -1 || arr[i] < arr[decIdx])
            ans = Math.max(ans, 1 + solve(i + 1, incIdx, i, arr, n));

        return dp[i][incIdx + 1][decIdx + 1] = ans;
    }

    public int minCount(int[] arr) {
        int n = arr.length;
        dp = new int[n + 1][n + 1][n + 1];

        for (int[][] plane : dp)
            for (int[] row : plane)
                Arrays.fill(row, -1);

        int maxIncluded = solve(0, -1, -1, arr, n);
        return n - maxIncluded;
    }
}