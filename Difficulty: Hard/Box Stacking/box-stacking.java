class Solution {
    public int maxHeight(int[] height, int[] width, int[] length) {
        int n = height.length;
        int[][] boxes = new int[3 * n][3];
        int index = 0;

        for (int i = 0; i < n; i++) {
            boxes[index][0] = Math.max(width[i], length[i]);
            boxes[index][1] = Math.min(width[i], length[i]);
            boxes[index][2] = height[i];
            index++;

            boxes[index][0] = Math.max(height[i], length[i]);
            boxes[index][1] = Math.min(height[i], length[i]);
            boxes[index][2] = width[i];
            index++;

            boxes[index][0] = Math.max(height[i], width[i]);
            boxes[index][1] = Math.min(height[i], width[i]);
            boxes[index][2] = length[i];
            index++;
        }

        java.util.Arrays.sort(boxes, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(b[0], a[0]);
    
            return Integer.compare(b[1], a[1]);
        });

        int totalBoxes = 3 * n;
        int[] dp = new int[totalBoxes];
        int maxHeight = 0;

        for (int i = 0; i < totalBoxes; i++) {
            dp[i] = boxes[i][2];
            for (int j = 0; j < i; j++) {
                if (boxes[i][0] < boxes[j][0] && boxes[i][1] < boxes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + boxes[i][2]);
                }
            }
            maxHeight = Math.max(maxHeight, dp[i]);
        }

        return maxHeight;
    }
}