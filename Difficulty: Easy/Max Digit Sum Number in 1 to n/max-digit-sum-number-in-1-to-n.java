class Solution {
    private static int getDigitSum(int val) {
        int sum = 0;
        while (val > 0) {
            sum += val % 10;
            val /= 10;
        }
        return sum;
    }

    public int findMax(int n) {
        String s = Integer.toString(n);
        int len = s.length();

        int bestNum = n;
        int bestSum = getDigitSum(n);

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '0')
                continue;

            StringBuilder sb = new StringBuilder();
            sb.append(s, 0, i);
            sb.append((char) (c - 1));
            for (int j = i + 1; j < len; j++)
                sb.append('9');

            int cand = Integer.parseInt(sb.toString());
            int candSum = getDigitSum(cand);

            if (candSum > bestSum || (candSum == bestSum && cand > bestNum)) {
                bestSum = candSum;
                bestNum = cand;
            }
        }

        return bestNum;
    }
}