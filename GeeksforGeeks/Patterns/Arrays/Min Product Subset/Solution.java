class Solution {
    public int minProd(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];

        int negCount = 0, zeroCount = 0;
        int maxNeg = Integer.MIN_VALUE;
        int minPos = Integer.MAX_VALUE;
        int product = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeroCount++;
                continue;
            }
            if (arr[i] < 0) {
                negCount++;
                maxNeg = Math.max(maxNeg, arr[i]);
            } else {
                minPos = Math.min(minPos, arr[i]);
            }
            product *= arr[i];
        }

        if (negCount == 0) {
            if (zeroCount > 0) return 0;
            return minPos;
        }

        if (negCount % 2 == 1) {
            return product;
        } else {
            return product / maxNeg;
        }
    }
}