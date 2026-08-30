import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        int n = l.length;
        long[] pref = new long[n];

        pref[0] = (long) r[0] - l[0] + 1;
        for (int i = 1; i < n; pref[i] = pref[i - 1] + ((long) r[i] - l[i] + 1), i++);

        ArrayList<Integer> result = new ArrayList<>();

        for (int q = 0; q < rank.length; q++) {
            long targetRank = rank[q];

            int low = 0, high = n - 1;
            int intervalIdx = n - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (pref[mid] >= targetRank) {
                    intervalIdx = mid;
                    high = mid - 1;
                } else
                    low = mid + 1;
            }

            long prevCount = (intervalIdx > 0) ? pref[intervalIdx - 1] : 0L;
            long offset = targetRank - prevCount - 1;
            int mark = (int) (l[intervalIdx] + offset);

            result.add(mark);
        }

        return result;
    }
}