class Solution {
    public int minMoves(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int val = arr[i];
            dp[val] = dp[val - 1] + 1;
            if (dp[val] > maxLen)
                maxLen = dp[val];
        }

        return n - maxLen;
    }
}