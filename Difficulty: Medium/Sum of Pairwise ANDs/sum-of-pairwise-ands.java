class Solution {
    public long pairAndSum(int[] arr) {
        long totalSum = 0;

        for (int b = 0; b < 32; b++) {
            long count = 0;
            int mask = 1 << b;

            for (int val : arr)
                if ((val & mask) != 0)
                    count++;

            long pairs = (count * (count - 1)) / 2;
            totalSum += pairs * (1L << b);
        }

        return totalSum;
    }
}