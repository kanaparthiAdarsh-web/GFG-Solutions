# Character at Position in Infinite String
> GeeksforGeeks · Medium · [problem](https://www.geeksforgeeks.org/problems/the-infinite-string1049/1)

## 📝 Problem

> Given a string s and an integer pos, an infinite string is constructed by repeatedly applying the following operation. In the i-th step, append i consecutive $ characters, followed by the reverse of the current string, to the current string.
>
> Formally, if the current string is s, update it as:
>
> s = s + ('$' repeated i times) + reverse(s)
>
> The initial string is the given s, and the process continues indefinitely.
>
> Find and return the character at the pos(1-based indexing) in the resulting infinite string.
>
> Examples:
>
> Input: s = "12345", pos = 3
> Output: 3
> Explanation: In "12345...", the character at pos 3 is 3.
>
> Input: s = "12345", pos = 10
> Output: 2
> Explanation: In "12345$54321...", the character at pos 10 is 2.
>
> Input: s = "abc", pos = 7
> Output: a
> Explanation: In "abc$cba...", the character at pos 7 is a.

AnyPush tracked this solution across **1 step**.

## Journey
1. **Step 1 · first solve** _(2026-11-23)_ — `v1.java`  
   This solution efficiently finds the character at a given `pos` in the infinite string by exploiting its recursive definition `S_k = S_{k-1} + C_k + S_{k-1}`. We

## Current solution
See [`solution.java`](./solution.java).
