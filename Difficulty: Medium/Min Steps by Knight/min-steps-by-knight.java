class Solution {
    public int minStepToReachTarget(int[] knightPos, int[] targetPos, int N) {
        if (knightPos[0] == targetPos[0] && knightPos[1] == targetPos[1])
            return 0;
        

        boolean[][] visited = new boolean[N + 1][N + 1];
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();

        queue.add(new int[]{knightPos[0], knightPos[1], 0});
        visited[knightPos[0]][knightPos[1]] = true;

        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int steps = curr[2];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx == targetPos[0] && ny == targetPos[1])
                    return steps + 1;
                

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, steps + 1});
                }
            }
        }

        return -1;
    }
}