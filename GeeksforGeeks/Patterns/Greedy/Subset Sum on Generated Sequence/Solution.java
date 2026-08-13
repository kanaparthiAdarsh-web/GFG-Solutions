import java.util.*;

class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        List<Long> l = new ArrayList<>();
        long c = s;
        if (s <= x) l.add((long) s);
        for (int v : arr)
        {
            long val = c + v;
            if (val > x) break;
            l.add(val);
            c += val;
        }
        long t = x;
        for (int i = l.size() - 1; i >= 0; i--)
            if (t >= l.get(i))
                t -= l.get(i);
        return t == 0;
    }
}