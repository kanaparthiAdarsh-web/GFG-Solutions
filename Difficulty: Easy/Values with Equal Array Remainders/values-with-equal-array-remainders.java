class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int sameMod(int[] arr) {
        int n = arr.length;
        if (n <= 1)
            return -1;

        int g = 0;
        for (int i = 1; i < n; g = gcd(g, Math.abs(arr[i] - arr[0])), i++);

        if (g == 0)
            return -1;

        int count = 0;
        for (int i = 1; (long) i * i <= g; i++)
            if (g % i == 0)
                count += (i * i == g)? 1 : 2;

        return count;
    }
}