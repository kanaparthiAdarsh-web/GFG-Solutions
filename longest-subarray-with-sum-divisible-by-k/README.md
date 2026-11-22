# Longest Subarray Sum Divisible by KSolved
> GeeksforGeeks · Medium · [problem](https://www.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1)

## 📝 Problem

> Given an array arr[] and a positive integer k, find the length of the longest subarray whose sum is divisible by k.
>
> Note: If there is no subarray with sum divisible by k, then return 0.
>
>
> Examples:
>
> Input: arr[] = [2, 7, 6, 1, 4, 5], k = 3
> Output: 4
> Explanation: The subarray [7, 6, 1, 4] has sum = 18, which is divisible by 3.
> Input: arr[] = [-2, 2, -5, 12, -11, -1, 7], k = 3
> Output: 5
> Explanation: The subarray [2, -5, 12, -11, -1] has sum = -3, which is divisible by 3.
>
> Input: arr[] = [1, 2, -2], k = 2
> Output: 2
> Explanation: The subarray is [2, -2] has sum = 0, which is divisible by 2.

AnyPush tracked this solution across **1 step**.

## Journey
1. **Step 1 · first solve** _(2026-11-22)_ — `v1.java`  
   This solution efficiently finds the longest subarray whose sum is divisible by K. It uses the prefix sum technique combined with a hash map. We iterate through 

## Current solution
See [`solution.java`](./solution.java).
