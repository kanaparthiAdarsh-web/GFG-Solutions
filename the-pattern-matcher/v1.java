/*
 * AnyPush — AI explanation
 * This solution directly parses the input string to verify the "x...xy...y" pattern. It iterates, consuming consecutive 'x's, then consecutive 'y's. For each detected block, it validates that the count of 'x's equals the count of 'y's, and both counts are positive. If any block fails this condition, or the string doesn't perfectly form such blocks, it immediately returns false.
 *
 * Time Complexity: O(N) because it iterates through the string exactly once.
 * Space Complexity: O(1) as it uses only a few constant-size integer variables.
 *
 * This direct, iterative parsing approach is highly efficient, providing optimal O(N) time and O(1) space. It's chosen for its predictability and minimal overhead, avoiding the potential complexity and performance costs associated with regular expressions or recursive parsing for this specific pattern. A seemingly simpler regex approach might incur significant performance penalties from the regex engine's setup and processing for longer strings.
 */

class Solution {
    public boolean findPattern(String s) {
        int i = 0;
        int n = s.length();

        while (i < n) {
            int countX = 0;
            while (i < n && s.charAt(i) == 'x') {
                countX++;
                i++;
            }
            int countY = 0;
            while (i < n && s.charAt(i) == 'y') {
                countY++;
                i++;
            }
            if (countX == 0 || countX != countY)
                return false;
            
        }

        return true;
    }
}
