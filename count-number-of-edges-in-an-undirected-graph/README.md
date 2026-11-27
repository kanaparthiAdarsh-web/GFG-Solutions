# Count Edges in Graph
> GeeksforGeeks · Easy · [problem](https://www.geeksforgeeks.org/problems/count-number-of-edges-in-an-undirected-graph/1)

## 📝 Problem

> Given an undirected graph with V vertices numbered from 0 to V - 1, represented by an adjacency list adj[][], where adj[i] contains the vertices adjacent to vertex i.
>
> Return the total number of edges present in the graph.
>
> Examples:
>
> Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3], [2]]
>
> Output: 4
> Explanation: The edges in the graph are: (0-1), (0-2), (2-3), (1-2). Hence, total number of edges = 4.
>
> Input: adj[][] = [[1], [0, 2], [1, 3], [2]]
>
> Output: 3
> Explanation: The edges in the graph are: (0-1), (1-2), (2-3). Hence, total number of edges = 3.

AnyPush tracked this solution across **1 step**.

## Journey
1. **Step 1 · first solve** _(2026-11-27)_ — `v1.java`  
   This solution directly applies the Handshaking Lemma, a fundamental graph theory property. The lemma states that the sum of degrees of all vertices in an undire

## Current solution
See [`solution.java`](./solution.java).
