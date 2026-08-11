import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> largestSquare(int[][] mat, int[][] queries, int k) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] pref = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref[i + 1][j + 1] = mat[i][j] + pref[i][j + 1] + pref[i + 1][j] - pref[i][j];
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int[] q : queries) {
            int cx = q[0];
            int cy = q[1];
            
            int maxRadius = Math.min(Math.min(cx, cy), Math.min(n - 1 - cx, m - 1 - cy));
            
            int low = 0, high = maxRadius;
            int bestRadius = -1;
            
            while (low <= high) {
                int mid = low + (high - low) / 2;
                
                int r1 = cx - mid, c1 = cy - mid;
                int r2 = cx + mid, c2 = cy + mid;
                
                int ones = pref[r2 + 1][c2 + 1] - pref[r1][c2 + 1] - pref[r2 + 1][c1] + pref[r1][c1];
                
                if (ones <= k) {
                    bestRadius = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            
            if (bestRadius == -1) {
                result.add(-1);
            } else {
                result.add(2 * bestRadius + 1);
            }
        }
        
        return result;
    }
}