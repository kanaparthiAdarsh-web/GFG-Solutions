class Solution {
    int transform(String s1, String s2) {
        if (s1.length() != s2.length())
            return -1;

        int[] count = new int[256];
        int n = s1.length();

        for (int k = 0; k < n; k++) {
            count[s1.charAt(k)]++;
            count[s2.charAt(k)]--;
        }

        for (int k = 0; k < 256; k++)
            if (count[k] != 0)
                return -1;

        int res = 0,i = n - 1, j = n - 1;

        while (i >= 0)
            if (s1.charAt(i) == s2.charAt(j)) {
                i--;
                j--;
            } else {
                res++;
                i--;
            }

        return res;
    }
}