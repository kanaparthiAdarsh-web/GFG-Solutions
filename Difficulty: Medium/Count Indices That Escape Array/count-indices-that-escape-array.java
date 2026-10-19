class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;
        int[] state = new int[n];
        int goodCount = 0;

        for (int i = 0; i < n; i++)
            if (dfs(i, arr, state))
                goodCount++;
        return goodCount;
    }

    private boolean dfs(int curr, int[] arr, int[] state) {
        if (curr < 0 || curr >= arr.length)
            return true;
        
        if (arr[curr] == 0) {
            state[curr] = 3;
            return false;
        }
        if (state[curr] == 2) 
            return true;
        if (state[curr] == 3 || state[curr] == 1) 
            return false;

        state[curr] = 1;
        int next = curr + arr[curr];
        boolean res = dfs(next, arr, state);

        state[curr] = res ? 2 : 3;
        return res;
    }
}