class Solution {
    private int[] tree;
    
    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = Math.max(tree[node], val);
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }
    
    private int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return Math.max(query(2 * node, start, mid, l, r), query(2 * node + 1, mid + 1, end, l, r));
    }
    
    public int maxStackHeight(int[] r, int[] h) {
        int n = r.length;
        int maxH = 0;
        for (int i = 0; i < n; i++) {
            if (h[i] > maxH) {
                maxH = h[i];
            }
        }
        
        int[][] discs = new int[n][2];
        for (int i = 0; i < n; i++) {
            discs[i][0] = r[i];
            discs[i][1] = h[i];
        }
        
        java.util.Arrays.sort(discs, (a, b) -> Integer.compare(a[0], b[0]));
        
        tree = new int[4 * (maxH + 1)];
        
        int ans = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && discs[j][0] == discs[i][0]) {
                j++;
            }
            
            int[] dp = new int[j - i];
            for (int k = i; k < j; k++) {
                int height = discs[k][1];
                int maxPrev = 0;
                if (height > 1) {
                    maxPrev = query(1, 1, maxH, 1, height - 1);
                }
                dp[k - i] = height + maxPrev;
            }
            
            for (int k = i; k < j; k++) {
                int height = discs[k][1];
                update(1, 1, maxH, height, dp[k - i]);
                if (dp[k - i] > ans) {
                    ans = dp[k - i];
                }
            }
            
            i = j;
        }
        
        return ans;
    }
}