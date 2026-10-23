class Solution {
    public int pairsViolatingBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.data);
            cur = cur.right;
        }

        int n = list.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = list.get(i);
        int[] tmp = new int[n];

        return (int) mergeCount(a, tmp, 0, n - 1);
    }

    private long mergeCount(int[] a, int[] tmp, int l, int r) {
        if (l >= r) return 0;
        int mid = (l + r) >>> 1;
        long cnt = mergeCount(a, tmp, l, mid) + mergeCount(a, tmp, mid + 1, r);

        int i = l, j = mid + 1, k = l;
        while (i <= mid && j <= r) {
            if (a[i] <= a[j])
                tmp[k++] = a[i++];
            else {
                cnt += mid - i + 1;
                tmp[k++] = a[j++];
            }
        }
        while (i <= mid) 
            tmp[k++] = a[i++];
        while (j <= r) 
            tmp[k++] = a[j++];
        for (int t = l; t <= r; t++) 
            a[t] = tmp[t];

        return cnt;
    }
}