/*
 * AnyPush — AI explanation
 * This solution efficiently finds the minimum flips required to transform a binary string into an alternating pattern. The core idea is that only two alternating patterns are possible: one starting with '0' (`01010...`) and one starting with '1' (`10101...`).
 *
 * We calculate the flips needed for the `01010...` pattern (`flipsStart0`) in a single pass. Crucially, any character that *doesn't* match the `01010...` pattern *must* match the `10101...` pattern. Therefore, the flips for the `10101...` pattern are simply `string_length - flipsStart0`. The answer is the minimum of these two flip counts.
 *
 * Time Complexity: O(N) - A single pass through the string of length N.
 * Space Complexity: O(1) - Constant extra space for a few integer variables.
 *
 * This approach is optimal as it directly computes flips for both target patterns by leveraging their complementary nature within a single O(N) pass. A more naive attempt might use two separate loops to calculate flips for each pattern independently, which would still be O(N) but less concise.
 */

class Solution {
    public int minFlips(String s) {
        int flipsStart0 = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char expected = (i % 2 == 0) ? '0' : '1';
            if (s.charAt(i) != expected)
                flipsStart0++;
        }

        return Math.min(flipsStart0, n - flipsStart0);
    }
}
