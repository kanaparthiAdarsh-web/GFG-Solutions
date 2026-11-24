/*
 * AnyPush — AI explanation
 * This solution iterates through all unique pairs of indices (i, j) to calculate their sum. It uses a hash map to store the first pair of indices found for each unique sum. When a sum is encountered again, we retrieve the previously stored pair and check if all four indices (from the current pair and the stored pair) are distinct. If they are, we've found two valid pairs with the same sum. The algorithm then updates a `best` result, keeping track of the lexicographically smallest set of four distinct indices found so far.
 *
 * Time Complexity: O(N^2) on average, due to iterating all pairs and O(1) average-case hash map operations.
 * Space Complexity: O(N^2) on average, as the hash map can store up to O(N^2) distinct sums and their index pairs.
 *
 * This approach is a good choice because it efficiently finds sum matches using hash map lookups, avoiding a much slower O(N^4) brute-force check. It guarantees the lexicographically smallest result by iterating pairs in increasing index order and meticulous comparison. A naive four-loop brute force would be prohibitively slow. While efficient in time, the O(N^2) space complexity could be a limiting factor for extremely large inputs beyond typical competitive programming constraints (e.g., N > 1000).
 */

import java.util.*;

class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {
        int n = arr.length;
        HashMap<Integer, int[]> map = new HashMap<>();
        int[] best = null;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (!map.containsKey(sum))
                    map.put(sum, new int[]{i, j});
                else {
                    int[] prev = map.get(sum);
                    int a = prev[0], b = prev[1];
                    if (a != i && a != j && b != i && b != j) {
                        int[] curr = new int[]{a, b, i, j};
                        if (best == null || isSmaller(curr, best))
                            best = curr;
                    }
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        if (best == null) {
            res.add(-1);
            res.add(-1);
            res.add(-1);
            res.add(-1);
        } else
            for (int idx : best)
                res.add(idx);
        return res;
    }

    private boolean isSmaller(int[] a, int[] b) {
        for (int i = 0; i < 4; i++)
            if (a[i] != b[i]) 
                return a[i] < b[i];
        return false;
    }
}
