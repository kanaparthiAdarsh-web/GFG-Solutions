class Solution {
    public char nthCharacter(int n) {
        long k = n;
        long count = 9;
        int digits = 1;
        long start = 1;

        while (k > count * digits) {
            k -= count * digits;
            digits++;
            count *= 10;
            start *= 10;
        }

        long num = start + (k - 1) / digits;
        int idx = (int) ((k - 1) % digits);

        return String.valueOf(num).charAt(idx);
    }
}