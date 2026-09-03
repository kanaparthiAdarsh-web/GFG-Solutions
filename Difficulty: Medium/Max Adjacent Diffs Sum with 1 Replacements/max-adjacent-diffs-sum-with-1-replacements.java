class Solution {
    public int maxDiffSum(int[] arr) {
        int n = arr.length;
        if (n <= 1)
            return 0;

        int dp0 = 0;
        int dp1 = 0;

        for (int i = 1; i < n; i++) {
            int nextDp0 = Math.max(dp0, dp1 + Math.abs(arr[i - 1] - 1));
            int nextDp1 = Math.max(dp0 + Math.abs(arr[i] - 1), dp1 + Math.abs(arr[i] - arr[i - 1]));
            dp0 = nextDp0;
            dp1 = nextDp1;
        }
        return Math.max(dp0, dp1);
    }
}