class Solution {
    private int minDiff;
    private Integer prev;

    private void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);

        if (prev != null)
            minDiff = Math.min(minDiff, root.data - prev);
            
        prev = root.data;

        inorder(root.right);
    }

    public int absDiff(Node root) {
        minDiff = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return minDiff;
    }
}