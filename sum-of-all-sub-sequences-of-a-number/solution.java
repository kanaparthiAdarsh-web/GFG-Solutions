/*
 * AnyPush — AI explanation
 * This solution efficiently calculates the sum of individual digits across all subsequences of the input string, modulo 10^9+7. The core idea relies on a combinatorial insight: each digit `d` in the original string appears in `2^(n-1)` subsequences (where `n` is the string length). Therefore, the total sum is simply `(sum of all original digits) * 2^(n-1)`.
 *
 * Time complexity is O(N) due to a single pass to sum digits and another to calculate 2^(n-1). Space complexity is O(1) for constant auxiliary variables.
 *
 * This approach is optimal as it avoids the exponential time complexity of explicitly generating all `2^N` subsequences, which a naive attempt would incur (O(2^N * N)). It directly leverages a mathematical property.
 *
 * The current solution's core logic is identical to a previously accepted version. This resubmission primarily incorporates a minor stylistic refinement to the loop computing `2^(n-1)`, enhancing conciseness. This reinforces that sometimes the most efficient algorithm is found early, with subsequent iterations focusing on code elegance. It taught us to always seek out such combinatorial shortcuts.
 */

class Solution {
    public int subsequenceSum(String s) {
        long sum = 0;
        long mod = 1000000007;
        int n = s.length();

        long p = 1;
        for (int i = 0; i < n - 1; p = (p * 2) % mod,i++);


        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            sum = (sum + digit) % mod;
        }

        long ans = (sum * p) % mod;
        return (int) ans;
    }
}
