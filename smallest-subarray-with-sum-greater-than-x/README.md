# Smallest Subarray Sum Greater Than x
> GeeksforGeeks · Easy · [problem](https://www.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1)

## 📝 Problem

> Given an integer x and an array of integers, arr[]. Find the length of the smallest subarray whose sum is strictly greater than x.
>
> If no such subarray exists, return 0.
>
> Examples:
>
> Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
> Output: 3
> Explanation: The smallest subarray with a sum greater than 51 is [4, 45, 6], whose sum is 55 and length is 3.
> Input: x = 100, arr[] = [1, 10, 5, 2, 7]
> Output: 0
> Explanation: No subarray has a sum greater than 100. Hence, the answer is 0.

AnyPush tracked this solution across **1 step**.

## Journey
1. **Step 1 · first solve** _(2026-11-21)_ — `v1.java`  
   This solution employs a two-pointer (sliding window) technique. We expand the window from the right, accumulating `currSum`. Once `currSum` exceeds `x`, we shri

## Current solution
See [`solution.java`](./solution.java).
