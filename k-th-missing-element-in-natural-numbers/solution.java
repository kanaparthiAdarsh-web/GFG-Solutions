/*
 * AnyPush — AI explanation
 * This solution finds the K-th missing natural number by first sorting the input array.
 * Sorting allows us to efficiently calculate the count of missing natural numbers up to any `arr[i]` as `arr[i] - (i + 1)`.
 * We iterate through the sorted array. If the number of missing elements up to `arr[i]` is greater than or equal to `k`, the K-th missing number can be directly derived.
 * If `k` is larger than the total missing numbers within the array's range, we calculate it by extending from the last element.
 *
 * Time Complexity: O(N log N) due to the initial sorting step.
 * Space Complexity: O(log N) auxiliary space for the recursion stack used by Java's `Arrays.sort()`.
 *
 * This approach is efficient because sorting enables a simple linear scan to pinpoint the missing number. While sorting incurs an O(N log N) cost, it is generally superior to naive iteration (which could be O(max(arr) + k) in worst case) when the maximum value in `arr` can be very large relative to N.
 * A simpler, though less efficient, approach would involve populating a `HashSet` with `arr` elements and then iterating natural numbers from 1, checking for presence until `k` missing numbers are found. This would cost O(N) space and could be much slower if `k` or `max(arr)` is large.
 */

class Solution {
    public int findKthSmall(int[] arr, int k) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int missingBefore = arr[i] - (i + 1);
            if (missingBefore >= k)
                return arr[i] - (missingBefore - k + 1);
        }

        return arr[arr.length - 1] + (k - (arr[arr.length - 1] - arr.length));
    }
}
