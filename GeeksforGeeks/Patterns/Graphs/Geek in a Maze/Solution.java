import java.util.PriorityQueue;

class Solution {
    public int numberOfCells(int r, int c, int u, int d, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        if (mat[r][c] == '#')
            return 0;

        int[][] minUp = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                minUp[i][j] = Integer.MAX_VALUE;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        minUp[r][c] = 0;
        pq.add(new int[]{r, c, 0, 0});

        int count = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cr = curr[0];
            int cc = curr[1];
            int upUsed = curr[2];
            int downUsed = curr[3];

            if (upUsed > minUp[cr][cc])
                continue;

            count++;

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] != '#') {
                    int nextUp = upUsed + (i == 0 ? 1 : 0);
                    int nextDown = downUsed + (i == 1 ? 1 : 0);

                    if (nextUp <= u && nextDown <= d && nextUp < minUp[nr][nc]) {
                        minUp[nr][nc] = nextUp;
                        pq.add(new int[]{nr, nc, nextUp, nextDown});
                    }
                }
            }
        }

        return count;
    }
}