/*
 * AnyPush — AI explanation
 * This solution efficiently finds the longest subarray whose sum is divisible by K. It uses the prefix sum technique combined with a hash map. We iterate through the array, maintaining a running prefix sum. For each sum, we calculate its remainder modulo K. If this remainder has been encountered before, it implies the sum of the subarray between the current index and the previously stored index for that remainder is divisible by K. We store the *first* occurrence of each remainder to maximize the subarray length.
 *
 * Time Complexity: O(N) due to a single pass through the array, with average O(1) hash map operations.
 * Space Complexity: O(K) as the map stores at most K distinct remainders.
 *
 * This approach is optimal for time complexity, significantly outperforming a naive O(N^2) solution that would iterate over all subarrays. The trade-off is using O(K) extra space, which is generally acceptable for the performance gain. A more naive O(N^2) approach checking all subarray sums would quickly lead to Time Limit Exceeded for larger inputs.
 */

class Solution {
    public int longestSubarrayDivK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        long sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int rem = (int) (((sum % k) + k) % k);

            if (map.containsKey(rem))
                maxLen = Math.max(maxLen, i - map.get(rem));
            else
                map.put(rem, i);
        }

        return maxLen;
    }
}
