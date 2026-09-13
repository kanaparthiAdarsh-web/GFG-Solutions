import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int[] bfs(int start, ArrayList<ArrayList<Integer>> adj, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();

        dist[start] = 0;
        q.offer(start);

        int farthestNode = start;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (dist[curr] > dist[farthestNode])
                farthestNode = curr;

            for (int neighbor : adj.get(curr)) {
                int next = neighbor - 1;
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    q.offer(next);
                }
            }
        }

        return new int[]{farthestNode, dist[farthestNode]};
    }

    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        if (n <= 1)
            return 0;

        int[] firstBFS = bfs(0, adj, n);
        int farthestFromRoot = firstBFS[0];

        int[] secondBFS = bfs(farthestFromRoot, adj, n);
        int diameter = secondBFS[1];

        return (diameter + 1) / 2;
    }
}