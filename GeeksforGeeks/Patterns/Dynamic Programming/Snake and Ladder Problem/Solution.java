import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int minThrows(int n, int[] lad, int[] sn) {
        int totalCells = n * n;
        int[] board = new int[totalCells + 1];

        for (int i = 0; i < lad.length; i += 2) {
            board[lad[i]] = lad[i + 1];
        }

        for (int i = 0; i < sn.length; i += 2) {
            board[sn[i]] = sn[i + 1];
        }

        boolean[] visited = new boolean[totalCells + 1];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cell = curr[0];
            int throwsCount = curr[1];

            if (cell == totalCells) {
                return throwsCount;
            }

            for (int dice = 1; dice <= 6 && cell + dice <= totalCells; dice++) {
                int nextCell = cell + dice;
                int finalCell = board[nextCell] != 0 ? board[nextCell] : nextCell;

                if (!visited[finalCell]) {
                    visited[finalCell] = true;
                    queue.add(new int[] {finalCell, throwsCount + 1});
                }
            }
        }

        return -1;
    }
}