import java.util.Arrays;

class Solution {
    public int maxProduct(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        if (k == n) {
            int prod = 1;
            for (int val : arr)
                prod *= val;
            return prod;
        }

        if (arr[n - 1] < 0 && k % 2 == 1) {
            int prod = 1;
            for (int i = n - 1; i >= n - k; i--)
                prod *= arr[i];
            return prod;
        }

        int prod = 1;
        int left = 0;
        int right = n - 1;

        if (k % 2 == 1) {
            prod *= arr[right];
            right--;
            k--;
        }

        while (k > 0) {
            int leftPair = arr[left] * arr[left + 1];
            int rightPair = arr[right] * arr[right - 1];

            if (leftPair > rightPair) {
                prod *= leftPair;
                left += 2;
            } else {
                prod *= rightPair;
                right -= 2;
            }
            k -= 2;
        }

        return prod;
    }
}