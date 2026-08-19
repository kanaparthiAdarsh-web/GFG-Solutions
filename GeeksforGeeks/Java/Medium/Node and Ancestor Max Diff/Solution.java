class Solution {
    private int maxDiffVal;

    private int dfs(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return root.data;
        }

        int leftMin = dfs(root.left);
        int rightMin = dfs(root.right);
        int minChild = Math.min(leftMin, rightMin);

        maxDiffVal = Math.max(maxDiffVal, root.data - minChild);
        return Math.min(root.data, minChild);
    }

    public int maxDiff(Node root) {
        maxDiffVal = Integer.MIN_VALUE;
        dfs(root);
        return maxDiffVal;
    }
}