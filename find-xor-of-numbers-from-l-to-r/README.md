# XOR of Number Range
> GeeksforGeeks · Easy · [problem](https://www.geeksforgeeks.org/problems/find-xor-of-numbers-from-l-to-r/1)

## 📝 Problem

> Given two integers l and r, find the bitwise XOR of all integers in the range [l, r] (both inclusive).
>
> Examples:
>
> Input: l = 4, r = 8
> Output: 8
> Explanation: The XOR of all integers from 4 to 8 is (4 xor 5 xor 6 xor 7 xor 8) = 8.
> Input: l = 2, r = 4
> Output: 5
> Explanation: The XOR of all integers from 2 to 4 is (2 xor 3 xor 4) = 5.
> Input: l = 5, r = 9
> Output: 5
> Explanation: The XOR of all integers from 5 to 9 is (5 xor 6 xor 7 xor 8 xor 9) = 5.
>
>
> Constraints:
>
>
> 1 ≤ l ≤ r ≤ 109

AnyPush tracked this solution across **1 step**.

## Journey
1. **Step 1 · first solve** _(2026-11-18)_ — `v1.java`  
   This solution efficiently calculates the XOR sum of numbers in a range [L, R] by leveraging the cyclic pattern of XOR sums from 1 to N. The `xorTill(n)` helper 

## Current solution
See [`solution.java`](./solution.java).
