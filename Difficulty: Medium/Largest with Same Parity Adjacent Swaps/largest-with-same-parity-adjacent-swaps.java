class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int val : arr)
            result.add(val);

        int n = arr.length;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && Math.abs(arr[j] % 2) == Math.abs(arr[i] % 2))
                j++;
                
            List<Integer> sublist = result.subList(i, j);
            sublist.sort(Collections.reverseOrder());
            i = j;
        }

        return result;
    }
}