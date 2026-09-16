class Solution {
    public int dominantPairs(int[] arr) {
        int n = arr.length;
    
        Arrays.sort(arr, 0, n / 2);
        Arrays.sort(arr, n / 2, n);

        int count = 0;
        int j = n / 2;

        for (int i = 0; i < n / 2; count += (j - n / 2), i++)
            while (j < n && arr[i] >= 5 * arr[j])
                j++;
                
        return count;
    }
}