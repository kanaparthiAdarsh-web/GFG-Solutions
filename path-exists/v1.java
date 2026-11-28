/*
 * AnyPush — AI explanation
 * This solution utilizes Breadth-First Search (BFS) starting from vertex 'u' to check if 'v' is reachable. It systematically explores the graph layer by layer, marking visited nodes to prevent infinite loops in cyclic graphs and redundant processing. If 'v' is encountered during this traversal, a path exists.
 *
 * Time Complexity: O(V + E), as BFS visits each vertex and edge at most once.
 * Space Complexity: O(V), required for the `visited` array and the queue.
 *
 * BFS is an excellent choice for unweighted graphs like this; it efficiently determines reachability and inherently finds the shortest path. Its iterative nature also avoids potential stack overflow issues that a recursive Depth-First Search might face on very deep graphs. A naive approach without a `visited` array would get stuck in cycles.
 */

class Solution {
    public boolean checkPath(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        if (u == v) return true;

        int n = adj.size();
        boolean[] visited = new boolean[n];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        visited[u] = true;
        queue.offer(u);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : adj.get(curr)) {
                if (next == v) return true;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return false;
    }
}
