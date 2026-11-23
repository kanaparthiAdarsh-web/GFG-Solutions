/*
 * AnyPush — AI explanation
 * This solution efficiently finds the character at a given `pos` in the infinite string by exploiting its recursive definition `S_k = S_{k-1} + C_k + S_{k-1}`. We avoid constructing the string.
 *
 * Core Idea:
 * 1. Precompute `len[k]` (length of `S_k`) using `len[k] = 2 * len[k-1] + k`.
 * 2. Find the smallest `step` where `pos` fits within `S_step`.
 * 3. Then, work downwards from `step`:
 *    - If `pos` is in the left `S_{step-1}`, solve for `S_{step-1}`.
 *    - If `pos` is in `C_step` (middle '$' chars), return '$'.
 *    - If `pos` is in the right `S_{step-1}`, map it to its symmetric position in the left half: `pos = len[step] - pos + 1`. This "folds" the problem.
 * Finally, `pos` will be within `S_0 = s`, so we return `s.charAt(pos-1)`.
 *
 * Time Complexity: O(log(pos)) because each step roughly halves the effective problem size.
 * Space Complexity: O(log(pos)) for storing the `len` array (approx 60 elements max).
 *
 * Why this is good:
 * It's essential for `pos` up to `10^18`, as explicit string construction is infeasible. The position mapping effectively reduces the problem domain in each recursive step.
 *
 * One note:
 * A naive string generation approach would quickly exceed time/memory limits. The `len` array could be optimized to `O(1)` space by only tracking the last two lengths, but `O(log(pos))` is already minimal.
 */

class Solution {
    public char posInfinite(String s, int pos) {
        long p = pos;
        long[] len = new long[65];
        len[0] = s.length();

        int step = 0;
        while (len[step] < p) {
            step++;
            len[step] = 2 * len[step - 1] + step;
        }

        for (int i = step; i >= 1; i--) {
            long prevLen = len[i - 1];
            if (p <= prevLen) {
                continue;
            } else if (p <= prevLen + i) {
                return '$';
            } else {
                p = len[i] - p + 1;
            }
        }

        return s.charAt((int) (p - 1));
    }
}
