/*
 * AnyPush — AI explanation
 * This solution employs a two-pointer (sliding window) technique. We expand the window from the right, accumulating `currSum`. Once `currSum` exceeds `x`, we shrink the window from the left, continuously updating `minLen` as long as `currSum` remains greater than `x`. This effectively finds the smallest valid subarray ending at the current right pointer.
 *
 * Time Complexity: O(N) because each array element is visited by the left and right pointers at most twice.
 * Space Complexity: O(1) as only a constant number of extra variables are used.
 *
 * This approach is highly efficient for contiguous subarray problems, providing optimal O(N) performance by avoiding the exhaustive O(N^2) checks of a naive brute-force method. It demonstrates how two-pointers can dramatically reduce complexity for such problems.
 */

class Solution {
    public int smallestSubWithSum(int[] arr, int x) {
        int n = arr.length;
        int minLen = Integer.MAX_VALUE;
        int currSum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            currSum += arr[right];

            while (currSum > x) {
                minLen = Math.min(minLen, right - left + 1);
                currSum -= arr[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
