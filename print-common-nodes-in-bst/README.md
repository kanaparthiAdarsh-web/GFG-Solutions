# Common Nodes in Two BSTs
> GeeksforGeeks · Medium · [problem](https://www.geeksforgeeks.org/problems/print-common-nodes-in-bst/1)

## 📝 Problem

> Given the roots r1 and r2 of two Binary Search Trees (BST), find all nodes that are present in both trees i.e. the intersection nodes of the two BSTs.
>
> Return the common node values in sorted order.
>
> Examples:
>
> Input: r1 = [5, 1, 10, 0, 4, 7, N, N, N, N, N, N, 9], r2 = [10, 7, 20, 4, 9, N, N]
>
> Output: [4, 7, 9, 10]
> Explanation: The values present in both BSTs are 4, 7, 9, and 10. Hence, the answer is [4, 7, 9, 10].
> Input: r1 = [10, 2, 11, 1, 3, N, N], r2 = [2, 1, 3]
>
> Output: [1, 2, 3]
> Explanation: The values 1, 2, and 3 are present in both BSTs. Hence, the answer is [1, 2, 3].

AnyPush tracked this solution across **2 steps**.

## Journey
1. **Step 1 · first solve** _(2026-11-13)_ — `v1.java`  
   This solution finds common nodes by performing a simultaneous in-order traversal on both BSTs. It uses two stacks to iteratively generate the next smallest node
2. **Step 2 · improved** _(2026-11-13)_ — `v2.java`  
   This solution efficiently finds common nodes by performing a simultaneous in-order traversal on both BSTs. We use two stacks to iteratively simulate in-order tr

## Current solution
See [`solution.java`](./solution.java).
