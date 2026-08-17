class Solution {
    public String compress(String s) {
        int n = s.length();
        int[] lps = new int[n];

        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        StringBuilder sb = new StringBuilder();
        int i = n - 1;

        while (i >= 0) {
            int len = i + 1;
            if (len % 2 == 0 && lps[i] >= len / 2 && len % (len - lps[i]) == 0 && (len / (len - lps[i])) % 2 == 0) {
                sb.append('*');
                i = len / 2 - 1;
            } else {
                sb.append(s.charAt(i));
                i--;
            }
        }

        return sb.reverse().toString();
    }
}