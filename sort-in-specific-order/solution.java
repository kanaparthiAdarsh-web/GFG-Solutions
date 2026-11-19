/*
 * AnyPush — AI explanation
 * The solution sorts numbers such that even numbers come first in ascending order, followed by odd numbers in descending order. This is achieved by temporarily negating all odd numbers. When sorted ascending, positive evens will precede negative odds (e.g., 2, 4, -5, -3). After sorting, the odd numbers are negated back to restore their original positive values, effectively ordering them in descending fashion (e.g., 2, 4, 5, 3).
 *
 * Time: O(N log N) due to the `Arrays.sort` call.
 * Space: O(1) auxiliary, as modifications are done in-place.
 *
 * This approach is efficient and leverages Java's highly optimized `Arrays.sort` for primitive arrays, avoiding the overhead of custom comparators on `Integer` objects or explicit partitioning into separate lists. It's a clever trick to achieve custom sorting order.
 *
 * A trade-off is the temporary modification of array elements. If the original values (prior to sorting) were strictly needed elsewhere, a copy or a more complex custom sorting approach would be required.
 */

import java.util.Arrays;

class Solution {
    public void sortIt(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++)
            if (arr[i] % 2 != 0)
                arr[i] = -arr[i];

        Arrays.sort(arr);

        for (int i = 0; i < n; i++)
            if (arr[i] < 0)
                arr[i] = -arr[i];
    }
}
