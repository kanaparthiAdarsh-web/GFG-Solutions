import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> socialNetwork(int[] arr) {
        int n = arr.length + 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 2; i <= n; i++) 
            for (int j = 1; j < i; j++) {
                int curr = i;
                int dist = 0;
                boolean found = false;
                boolean[] visited = new boolean[n + 1];

                while (curr != 1 && !visited[curr]) {
                    visited[curr] = true;
                    curr = arr[curr - 2];
                    dist++;
                    if (curr == j) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    ArrayList<Integer> path = new ArrayList<>();
                    path.add(i);
                    path.add(j);
                    path.add(dist);
                    result.add(path);
                }
            }

        return result;
    }
}