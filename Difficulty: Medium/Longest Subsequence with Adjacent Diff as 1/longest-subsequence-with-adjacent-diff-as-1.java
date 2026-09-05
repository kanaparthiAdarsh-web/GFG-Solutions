class Solution {
    public int longestSubseq(int[] arr) {
        int n = arr.length;
        if (n <= 1)
            return n;

        int maxVal = 0;
        for (int x : arr)
            if (x > maxVal)
                maxVal = x;

        int[] dp = new int[maxVal + 2];
        int maxLen = 0;

        for (int x : arr) {
            int left = (x > 0) ? dp[x - 1] : 0;
            int right = dp[x + 1];

            dp[x] = 1 + Math.max(left, right);

            if (dp[x] > maxLen)
                maxLen = dp[x];
        }

        return maxLen;
    }
}