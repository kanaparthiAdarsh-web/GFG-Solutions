# Path Exists Between Two VerticesSolved
> GeeksforGeeks · Easy · [problem](https://www.geeksforgeeks.org/problems/path-exists/1)

## 📝 Problem

> Given an undirected graph with V vertices numbered from 0 to V - 1, represented by an adjacency list adj[][], where adj[i] contains all vertices adjacent to vertex i. Also given two vertices u and v, check whether a path exists between them.
>
> Return true if a path exists, otherwise return false.
>
> Examples:
>
> Input: adj[][] = [[2, 3], [2], [0, 1], [0], [5], [4]], u = 1, v = 5
>
> Output: false
> Explanation: There is no path from vertex 1 to vertex 5.
> Input: adj[][] = [[2, 3], [2], [0, 1], [0], [5], [4]], u = 2, v = 3
>
> Output: true
> Explanation: We can reach vertex 3 from vertex 2 via vertex 0.

AnyPush tracked this solution across **1 step**.

## Journey
1. **Step 1 · first solve** _(2026-11-28)_  
   This solution utilizes Breadth-First Search (BFS) starting from vertex 'u' to check if 'v' is reachable. It systematically explores the graph layer by layer, ma

> ✅ **Merged** — the per-step files were collapsed into `solution.java`. The journey above is the kept record.

## Current solution
See [`solution.java`](./solution.java).
