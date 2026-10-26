class Solution {
    public int minDiff(int k, int[] arr) {
        int n = arr.length;
        int[] preMin = new int[n + 1];
        int[] preMax = new int[n + 1];
        int[] sufMin = new int[n + 2];
        int[] sufMax = new int[n + 2];

        preMin[0] = Integer.MAX_VALUE;
        preMax[0] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            preMin[i + 1] = Math.min(preMin[i], arr[i]);
            preMax[i + 1] = Math.max(preMax[i], arr[i]);
        }

        sufMin[n] = Integer.MAX_VALUE;
        sufMax[n] = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            sufMin[i] = Math.min(sufMin[i + 1], arr[i]);
            sufMax[i] = Math.max(sufMax[i + 1], arr[i]);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i + k <= n; i++) {
            int mn = Math.min(preMin[i], sufMin[i + k]);
            int mx = Math.max(preMax[i], sufMax[i + k]);
            ans = Math.min(ans, mx - mn);
        }

        return ans;
    }
}