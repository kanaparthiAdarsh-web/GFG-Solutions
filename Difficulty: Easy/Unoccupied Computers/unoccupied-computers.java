class Solution {
    public int solve(int n, String s) {
        int[] status = new int[26];
        int occupied = 0;
        int rejectedCount = 0;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'A';

            if (status[idx] == 0)
                if (occupied < n) {
                    status[idx] = 1;
                    occupied++;
                } else {
                    status[idx] = 2;
                    rejectedCount++;
                }
            else 
                if (status[idx] == 1)
                occupied--;
        }

        return rejectedCount;
    }
}