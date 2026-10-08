class Solution {
    public int maxFrequency(int[] arr, int k) {
        java.util.Arrays.sort(arr);
        int n = arr.length;
        long sum = 0;
        int left = 0, best = 1;

        for (int right = 0; right < n; best = Math.max(best, right - left + 1),right++) {
            sum += arr[right];
            while ((long) arr[right] * (right - left + 1) - sum > k) {
                sum -= arr[left];
                left++;
            }
            
        }
        return best;
    }
}