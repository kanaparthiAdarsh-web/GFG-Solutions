import java.util.*;

class Solution {
    public int longestPath(String s, int[][] edges) {
        int n = s.length();
        int m = 2 * edges.length;
        int[] head = new int[n + 1];
        Arrays.fill(head, -1);
        int[] nxt = new int[m], to = new int[m];
        int idx = 0;
        for (int[] e : edges) {
            to[idx] = e[1]; nxt[idx] = head[e[0]]; head[e[0]] = idx++;
            to[idx] = e[0]; nxt[idx] = head[e[1]]; head[e[1]] = idx++;
        }

        int[] order = new int[n];
        int[] par = new int[n + 1];
        int qh = 0, qt = 0;
        order[qt++] = 1;
        while (qh < qt) {
            int u = order[qh++];
            for (int i = head[u]; i != -1; i = nxt[i]) {
                int v = to[i];
                if (v != par[u]) {
                    par[v] = u;
                    order[qt++] = v;
                }
            }
        }

        int[] r = new int[n + 1], b = new int[n + 1];
        int[] rb = new int[n + 1], br = new int[n + 1];
        int ans = 1;

        for (int k = n - 1; k >= 0; k--) {
            int u = order[k];
            boolean red = s.charAt(u - 1) == 'R';
            int best1 = 0, best2 = 0, cand = 0;

            for (int i = head[u]; i != -1; i = nxt[i]) {
                int v = to[i];
                if (v == par[u]) continue;
                if (red) {
                    cand = Math.max(cand, Math.max(best1 + rb[v], r[v] + best2));
                    best1 = Math.max(best1, r[v]);
                    best2 = Math.max(best2, rb[v]);
                } else {
                    cand = Math.max(cand, Math.max(best1 + br[v], b[v] + best2));
                    best1 = Math.max(best1, b[v]);
                    best2 = Math.max(best2, br[v]);
                }
            }

            if (red) {
                r[u] = 1 + best1;
                rb[u] = 1 + best2;
                br[u] = r[u];
                b[u] = 0;
            } else {
                b[u] = 1 + best1;
                br[u] = 1 + best2;
                rb[u] = b[u];
                r[u] = 0;
            }
            ans = Math.max(ans, 1 + cand);
        }
        return ans;
    }
}