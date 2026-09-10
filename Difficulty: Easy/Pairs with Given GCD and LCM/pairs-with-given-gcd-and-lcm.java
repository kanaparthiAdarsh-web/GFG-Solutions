class Solution {
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int pairCount(int x, int y) {
        if (y % x != 0)
            return 0;

        int count = 0;

        for (int p = 1; p * p <= (y / x); p++)
            if ((y / x) % p == 0)
                if (gcd(p, (y / x)/p) == 1) 
                    count += (p == (y / x)/p) ? 1 : 2;
        return count;
    }
}