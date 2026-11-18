/*
 * AnyPush — AI explanation
 * This solution efficiently calculates the XOR sum of numbers in a range [L, R] by leveraging the cyclic pattern of XOR sums from 1 to N. The `xorTill(n)` helper function computes XOR(1...n) in constant time based on `n % 4`. The XOR of the range `[L, R]` is then derived using the property: `xorTill(R) ^ xorTill(L - 1)`.
 *
 * Time Complexity: O(1) - The `xorTill` function involves only modulo, arithmetic, and XOR operations, all in constant time.
 * Space Complexity: O(1) - No auxiliary data structures are used.
 *
 * This approach is highly efficient, providing a constant-time solution. It's crucial for problems where the range [L, R] can be extremely large (e.g., 10^9), as a linear scan would be too slow and lead to a Time Limit Exceeded error.
 *
 * A naive approach would iterate from L to R, XORing each number, resulting in O(R-L+1) time. While simple to implement, it would fail for large ranges. The current solution is optimal and cannot be significantly improved in terms of asymptotic complexity.
 */

class Solution {
    public int findXOR(int l, int r) {
        return xorTill(r) ^ xorTill(l - 1);
    }

    private int xorTill(int n) {
        switch (n % 4) {
            case 0: return n;
            case 1: return 1;
            case 2: return n + 1;
            default: return 0;
        }
    }
}
