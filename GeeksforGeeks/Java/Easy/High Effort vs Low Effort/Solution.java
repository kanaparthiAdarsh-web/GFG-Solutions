class Solution {
    public int maxTask(int[] h, int[] l) {
        int n = h.length;
        if (n == 0) return 0;
        
        int none = 0;
        int low = l[0];
        int high = h[0];
        
        for (int i = 1; i < n; i++) {
            int prevNone = none;
            int prevLow = low;
            int prevHigh = high;
            
            none = Math.max(prevNone, Math.max(prevLow, prevHigh));
            low = l[i] + Math.max(prevNone, Math.max(prevLow, prevHigh));
            high = h[i] + prevNone;
        }
        
        return Math.max(none, Math.max(low, high));
    }
}