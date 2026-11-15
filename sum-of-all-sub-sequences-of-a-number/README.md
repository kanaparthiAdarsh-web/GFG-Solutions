# Sum of All Digit SubsequencesSolved
> GeeksforGeeks · Easy · [problem](https://www.geeksforgeeks.org/problems/sum-of-all-sub-sequences-of-a-number3437/1)

## 📝 Problem

> Given a string s which consists of digits, find sum of all digits across all non-empty subsequences of s.
>
> Note: Since the answer can be very large, return it modulo 10^9 + 7.
>
> Examples:
>
> Input: s = "123"
> Output: 24
> Explanation: The non-empty subsequences are: [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]. The sum of all digits in these subsequences is: 1 + 2 + 3 + (1 + 2) + (1 + 3) + (2 + 3) + (1 + 2 + 3) = 24.
>
> Input: s = "405"
> Output: 36
> Explanation: The non-empty subsequences are: [4], [0], [5], [4, 0], [4, 5], [0, 5], [4, 0, 5]. The sum of all digits in these subsequences is 36.

AnyPush tracked this solution across **2 steps**.

## Journey
1. **Step 1 · first solve** _(2026-11-15)_ — `v1.java`  
   This solution calculates the sum of *individual digit values* across all possible subsequences of the input string.
2. **Step 2 · improved** _(2026-11-15)_ — `v2.java`  
   This solution efficiently calculates the sum of individual digits across all subsequences of the input string, modulo 10^9+7. The core idea relies on a combinat

## Current solution
See [`solution.java`](./solution.java).
