/*
 * AnyPush — AI explanation
 * This solution directly applies the Handshaking Lemma, a fundamental graph theory property. The lemma states that the sum of degrees of all vertices in an undirected graph is equal to twice the total number of edges. We compute this sum by iterating through the adjacency list, accumulating the `size()` of each vertex's neighbor list (its degree). Finally, dividing this total sum by two yields the edge count.
 *
 * Time Complexity: O(V + E), as we traverse the adjacency list once, visiting each vertex and edge.
 * Space Complexity: O(1) auxiliary space, using only a single integer variable to store the sum of degrees.
 *
 * This approach is highly efficient and optimal because it leverages a direct mathematical relationship, avoiding any complex logic or additional data structures. It performs the absolute minimum work required to read the entire graph representation.
 *
 * One important note is that this solution assumes an undirected graph. For a directed graph where `adj[i]` stores out-neighbors, the sum of all `adj[i].size()` directly gives the number of edges without needing to divide by two.
 */

class Solution {
    public int countEdges(ArrayList<ArrayList<Integer>> adj) {
        int totalDegrees = 0;
        for (ArrayList<Integer> neighbors : adj)
            totalDegrees += neighbors.size();
        return totalDegrees / 2;
    }
}
