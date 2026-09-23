class Solution {
    public int formPyramid(int[] arr) {
        int n = arr.length;
        long totalHeight = 0;
        for (int x : arr)
            totalHeight += x;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) 
            left[i] = Math.min(arr[i], left[i - 1] + 1);

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.min(arr[i], right[i + 1] + 1);
        }

        long maxPyramidSum = 0;
        for (int i = 0; i < n; i++) {
            int peakHeight = Math.min(left[i], right[i]);
            maxPyramidSum = Math.max(maxPyramidSum, (long) peakHeight * peakHeight);
        }

        return (int) (totalHeight - maxPyramidSum);
    }
}