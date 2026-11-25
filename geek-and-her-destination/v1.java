/*
 * AnyPush — AI explanation
 * This solution calculates the total minimum time to reach a destination `d` for all points `x` in the range `[d-r, d-l]`. The core idea is to decompose the total cost for each `x` into two parts: a base cost `(x+1)` and a conditional "special jump" cost `2*b*ceil((x-a)/(a-b))` applied when `x > a`.
 *
 * Both components are then summed efficiently over the specified range `[d-r, d-l]`. The sum of `(x+1)` terms is a standard arithmetic progression, computed in O(1). The sum of `ceil` terms is also handled in O(1) using a closed-form formula (`prefixCeilSum`) that aggregates `ceil(i/C)` for `i=1 to N` by leveraging properties of integer division and arithmetic series.
 *
 * This approach achieves O(1) time complexity and O(1) space complexity, as it involves only a fixed number of arithmetic operations. This efficiency is critical because the range `[d-r, d-l]` can span up to 10^18 elements, meaning any iterative O(N) solution would trivially result in a Time Limit Exceeded (TLE). The mathematical summation avoids any direct iteration over the massive range.
 *
 * A more naive attempt would involve iterating through each `x` in the range, incurring an insurmountable `O(R-L)` cost. While the current solution is highly optimized, careful application of modulo operations at each intermediate step is essential to prevent arithmetic overflows before the final result.
 */

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int minTime(int a, int b, int d, int l, int r) {
        long L = d - r;
        long R = d - l;
        long count = R - L + 1;

        long sumXPlus1 = (count * (L + R + 2) / 2) % MOD;

        long A = Math.max(L, (long) a + 1);
        long sumK = 0;
        if (A <= R) {
            long c = a - b;
            long U = A - a;
            long V = R - a;
            sumK = (prefixCeilSum(V, c) - prefixCeilSum(U - 1, c)) % MOD;
        }

        long ans = (sumXPlus1 + (2L * b % MOD) * sumK % MOD) % MOD;
        return (int) ans;
    }

    private long prefixCeilSum(long n, long c) {
        if (n <= 0) 
            return 0;
        long q = n / c;
        long rem = n % c;
        return c * (q * (q + 1) / 2) + rem * (q + 1);
    }
}
