class Solution {
    public String lexiString(String s) {
        String ss = s + s;
        int n = s.length();
        int i = 0, j = 1, k = 0;
        while (i < n && j < n && k < n) {
            char c1 = ss.charAt(i + k);
            char c2 = ss.charAt(j + k);
            if (c1 == c2)
                k++;
             else if (c1 > c2) {
                i = Math.max(i + k + 1, j);
                j = i + 1;
                k = 0;
            } else {
                j = Math.max(j + k + 1, i + 1);
                k = 0;
            }
        }
        int start = (i < n) ? i : j;
        return ss.substring(start, start + n);
    }
}