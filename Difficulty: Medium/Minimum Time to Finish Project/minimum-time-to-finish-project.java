class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; adj[i] = new ArrayList<>(),i++);

        int[] inDegree = new int[n];
        for (int[] edge : dependencies) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            inDegree[v]++;
        }

        java.util.Queue<Integer> q = new java.util.LinkedList<>();
        int[] startTime = new int[n];
        for (int i = 0; i < n; i++)
            if (inDegree[i] == 0) {
                q.add(i);
                startTime[i] = 0;
            }

        int count = 0;
        int maxTime = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            count++;
            int finishTime = startTime[u] + duration[u];
            maxTime = Math.max(maxTime, finishTime);

            for (int v : adj[u]) {
                startTime[v] = Math.max(startTime[v], finishTime);
                inDegree[v]--;
                if (inDegree[v] == 0)
                    q.add(v);
            }
        }

        if (count < n)
            return -1;
        
        return maxTime;
    }
}