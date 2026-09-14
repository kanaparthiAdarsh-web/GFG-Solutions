import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] safe = new boolean[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(safe[i], true);
            
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    safe[i][j] = false;
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dr[d];
                        int nj = j + dc[d];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < m)
                            safe[ni][nj] = false;
                    }
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
            if (safe[i][0]) {
                dist[i][0] = 1;
                queue.offer(new int[]{i, 0});
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            if (c == m - 1)
                return dist[r][c];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && safe[nr][nc] && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }
}