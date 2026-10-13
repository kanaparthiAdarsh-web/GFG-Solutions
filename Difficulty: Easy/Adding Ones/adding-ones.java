class Solution {
    public ArrayList<Integer> update(int n, int[] updates) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] arr = new int[n + 2];

        for (int u : updates) 
            arr[u]++;
        

        int currentSum = 0;
        for (int i = 1; i <= n; i++) {
            currentSum += arr[i];
            result.add(currentSum);
        }

        return result;
    }
}