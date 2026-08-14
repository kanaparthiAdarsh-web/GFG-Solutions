class Solution {
    public int countWithout(int n, int d) {
        String s = String.valueOf(n);
        Long[][][] memo = new Long[s.length()][2][2];
        return (int) dp(s.toCharArray(), 0, true, true, d, memo);
    }

    private long dp(char[] digits, int idx, boolean tight, boolean leadingZero, int d, Long[][][] memo) {
        if (idx == digits.length) {
            return leadingZero ? 0 : 1;
        }

        int tIdx = tight ? 1 : 0;
        int lzIdx = leadingZero ? 1 : 0;
        if (memo[idx][tIdx][lzIdx] != null) {
            return memo[idx][tIdx][lzIdx];
        }

        int limit = tight ? (digits[idx] - '0') : 9;
        long count = 0;

        for (int i = 0; i <= limit; i++) {
            // Allow '0' as a leading zero even if d = 0, but skip it if it's a real digit or equals d
            if (i == d && (i != 0 || !leadingZero)) {
                continue;
            }

            boolean nextTight = tight && (i == limit);
            boolean nextLeadingZero = leadingZero && (i == 0);

            count += dp(digits, idx + 1, nextTight, nextLeadingZero, d, memo);
        }

        return memo[idx][tIdx][lzIdx] = count;
    }
}