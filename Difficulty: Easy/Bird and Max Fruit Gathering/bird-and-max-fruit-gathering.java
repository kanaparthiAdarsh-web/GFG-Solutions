import java.util.ArrayList;

class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        if (n == 0 || m <= 0)
            return 0;

        int currentSum = 0;
        for (int i = 0; i < Math.min(m, n); currentSum += arr.get(i), i++);

        int maxSum = currentSum;

        if (Math.min(m, n) == n)
            return maxSum;

        for (int i = 0; i < n; currentSum = currentSum - arr.get(i) + arr.get((i + Math.min(m, n)) % n), i++)
            if (currentSum > maxSum)
                maxSum = currentSum;

        return maxSum;
    }
}