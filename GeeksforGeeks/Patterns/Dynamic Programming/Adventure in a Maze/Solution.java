import java.util.ArrayList;

class Solution {
    static final int MOD = 1000000007;

    public ArrayList<Integer> findWays(int[][] grid) {
        int n = grid.length;
        long[][] memoPaths = new long[n][n];
        long[][] memoAdv = new long[n][n];
        boolean[][] visited = new boolean[n][n];

        return dfs(0, 0, n, grid, memoPaths, memoAdv, visited);
    }

    private ArrayList<Integer> dfs(int r, int c, int n, int[][] grid, long[][] memoPaths, long[][] memoAdv, boolean[][] visited) {
        if (r == n - 1 && c == n - 1) {
            ArrayList<Integer> baseResult = new ArrayList<>();
            baseResult.add(1);
            baseResult.add(grid[r][c]);
            return baseResult;
        }
        
        if (r >= n || c >= n) {
            ArrayList<Integer> emptyResult = new ArrayList<>();
            emptyResult.add(0);
            emptyResult.add(0);
            return emptyResult;
        }

        if (visited[r][c]) {
            ArrayList<Integer> memoResult = new ArrayList<>();
            memoResult.add((int) memoPaths[r][c]);
            memoResult.add((int) memoAdv[r][c]);
            return memoResult;
        }

        long totalPaths = 0;
        long maxAdventure = 0;
        int cellValue = grid[r][c];

        if (cellValue == 1 || cellValue == 3) {
            ArrayList<Integer> rightResult = dfs(r, c + 1, n, grid, memoPaths, memoAdv, visited);
            if (rightResult.get(0) > 0) {
                totalPaths = (totalPaths + rightResult.get(0)) % MOD;
                maxAdventure = Math.max(maxAdventure, rightResult.get(1));
            }
        }

        if (cellValue == 2 || cellValue == 3) {
            ArrayList<Integer> downResult = dfs(r + 1, c, n, grid, memoPaths, memoAdv, visited);
            if (downResult.get(0) > 0) {
                totalPaths = (totalPaths + downResult.get(0)) % MOD;
                maxAdventure = Math.max(maxAdventure, downResult.get(1));
            }
        }

        if (totalPaths > 0) {
            maxAdventure += cellValue;
        }

        memoPaths[r][c] = totalPaths;
        memoAdv[r][c] = maxAdventure;
        visited[r][c] = true;

        ArrayList<Integer> finalResult = new ArrayList<>();
        finalResult.add((int) totalPaths);
        finalResult.add((int) maxAdventure);
        return finalResult;
    }
}