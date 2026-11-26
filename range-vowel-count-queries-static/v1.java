/*
 * AnyPush — AI explanation
 * This solution efficiently handles range vowel count queries using the prefix sum technique.
 * First, a prefix array is constructed where `prefix[i]` stores the total count of vowels from string index 0 up to `i-1`.
 * Then, for each query `[L, R]`, the vowel count is simply `prefix[R+1] - prefix[L]`, as each query becomes an O(1) lookup.
 *
 * Time Complexity: O(N + Q) where N is string length, Q is number of queries. O(N) for prefix array build, O(Q) for queries.
 * Space Complexity: O(N) for the prefix sum array.
 *
 * This approach is highly effective because it transforms a potentially O(N) query into an O(1) operation after an initial O(N) setup. This drastically speeds up solutions with many queries, avoiding the `Time Limit Exceeded` error that a naive O(N*Q) approach (iterating for each query) would face for large inputs.
 */

import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
        int n = s.length();
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            prefix[i + 1] = prefix[i] + ((c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0);
        }

        ArrayList<Integer> result = new ArrayList<>(queries.length);
        for (int[] q : queries)
            result.add(prefix[q[1] + 1] - prefix[q[0]]);

        return result;
    }
}
