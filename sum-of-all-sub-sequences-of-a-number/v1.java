/*
 * AnyPush — AI explanation
 * This solution calculates the sum of *individual digit values* across all possible subsequences of the input string.
 * The core idea is that each digit `d` at a specific position contributes its value exactly `2^(N-1)` times to the total sum, where `N` is the string length. This is because for `d` to be included in a subsequence, it's chosen, and the remaining `N-1` digits each have 2 choices (include or exclude).
 * Therefore, the total sum is the sum of all individual digits in the original string, multiplied by `2^(N-1)`, with all calculations taken modulo 10^9 + 7.
 * Time Complexity: O(N) as it involves a single pass for digit summation and power calculation.
 * Space Complexity: O(1) using only a few auxiliary variables.
 * This approach is highly efficient, directly applying a combinatorial insight. It's optimal for summing individual digit contributions, avoiding the exponential cost of generating all subsequences.
 * Note: If subsequences like "12" were to be interpreted as the number twelve (as in some problem interpretations), a dynamic programming approach involving powers of 10 would be necessary, leading to a more complex solution.
 */

class Solution {
    public int subsequenceSum(String s) {
        long sum = 0;
        long mod = 1000000007;
        int n = s.length();

        long p = 1;
        for (int i = 0; i < n - 1; i++) {
            p = (p * 2) % mod;
        }

        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            sum = (sum + digit) % mod;
        }

        long ans = (sum * p) % mod;
        return (int) ans;
    }
}
