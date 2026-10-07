class Solution {
    int maxSum;

    public int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }

    private int dfs(Node node) {
        if (node == null) 
            return 0;

        if (node.left == null && node.right == null) 
            return node.data;

        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);

        if (node.left != null && node.right != null) {
            maxSum = Math.max(maxSum, leftSum + rightSum + node.data);
            return Math.max(leftSum, rightSum) + node.data;
        }

        return (node.left == null ? rightSum : leftSum) + node.data;
    }
}