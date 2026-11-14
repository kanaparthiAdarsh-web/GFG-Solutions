# Max Equal Sum in 3 Stacks
> GeeksforGeeks · Medium · [problem](https://www.geeksforgeeks.org/problems/find-maximum-equal-sum-of-three-stacks/1)

## 📝 Problem

> Given three stacks s1, s2, and s3, represented by arrays where the first element of each array represents the top of the corresponding stack.
>
> Find the maximum possible equal sum(sum of all elements) of all three stacks by removing zero or more elements from the top of each stack.
>
> If it is not possible to make the sum of all three stacks equal, return 0.
>
> Examples:
>
> Input: s1 = [3, 2, 1, 1, 1], s2 = [4, 3, 2], s3 = [2, 5, 4, 1]
> Output: 5
> Explanation: Remove 3 from s1, 4 from s2, and 2, 5 from s3. The remaining sums of all three stacks are equal to 5.
>
> Input: s1 = [4,7], s2 = [10], s3 = [1,2,3]
> Output: 0
> Explanation: It is not possible to make the sums of all three stacks equal by removing elements from their tops.

AnyPush tracked this solution across **1 step**.

## Journey
1. **Step 1 · first solve** _(2026-11-14)_ — `v1.java`  
   This solution employs a greedy strategy to find the maximum equal sum. It starts by calculating the total sum of elements in each of the three stacks. Then, it 

## Current solution
See [`solution.java`](./solution.java).
