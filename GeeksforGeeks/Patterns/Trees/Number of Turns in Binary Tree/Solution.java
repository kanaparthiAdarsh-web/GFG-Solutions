class Solution {
    private int count;

    private Node findLCA(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2)
            return root;
        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);
        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }

    private boolean countTurns(Node root, int key, boolean turn) {
        if (root == null) 
            return false;
            
        if (root.data == key)
            return true;
        if (turn) {
            if (countTurns(root.left, key, turn))
                return true;
                
            if (countTurns(root.right, key, !turn)) {
                count++;
                return true;
            }
        } else {
            if (countTurns(root.right, key, turn))
                return true;
            if (countTurns(root.left, key, !turn)) {
                count++;
                return true;
            }
        }
        return false;
    }

    public int numberOfTurns(Node root, int p, int q) {
        Node lca = findLCA(root, p, q);
        if (lca == null) {
            return -1;
        }

        count = 0;

        if (lca.data != p && lca.data != q) {
            if (countTurns(lca.left, p, true) || countTurns(lca.right, p, false))
                if (countTurns(lca.left, q, true) || countTurns(lca.right, q, false))
                    return count + 1;
            return -1;
        }

        if (lca.data == p) {
            countTurns(lca.left, q, true);
            countTurns(lca.right, q, false);
        } else {
            countTurns(lca.left, p, true);
            countTurns(lca.right, p, false);
        }

        return count == 0 ? -1 : count;
    }
}