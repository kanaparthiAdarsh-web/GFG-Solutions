class Solution {
    public String findRollOut(String s, int[] roll) {
        int n = s.length();
        int[] counts = new int[n + 1];

        for (int r : roll) {
            counts[0]++;
            if (r < n)
                counts[r]--;
        }

        char[] chars = s.toCharArray();
        int currentRoll = 0;

        for (int i = 0; i < n; i++) {
            currentRoll += counts[i];
            int shift = currentRoll % 26;
            chars[i] = (char) ('a' + (chars[i] - 'a' + shift) % 26);
        }

        return new String(chars);
    }
}