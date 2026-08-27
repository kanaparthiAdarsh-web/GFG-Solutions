import java.util.Arrays;

class Solution {
    public int maxArea(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] heights = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (mat[i][j] == 1)
                    heights[j]++;
                else
                    heights[j] = 0;

            int[] sorted = heights.clone();
            Arrays.sort(sorted);

            for (int j = 0; j < m; j++) {
                int area = sorted[j] * (m - j);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }
}