class Solution {
    public int minimumSum(String s) {
        int n = s.length();
        int m = (n + 1) / 2;
        char[] h = new char[m];

        for (int i = 0; i < m; i++) {
            char a = s.charAt(i);
            char b = s.charAt(n - 1 - i);
            if (a != '?' && b != '?' && a != b) 
                return -1;
            h[i] = a != '?' ? a : b;
        }

        int sum = 0,prev = -1;
        for (int i = 0; i < m; i++)
            if (h[i] != '?') {
                if (prev != -1) 
                    sum += Math.abs(h[i] - prev);
                prev = h[i];
            }

        return 2 * sum;
    }
}