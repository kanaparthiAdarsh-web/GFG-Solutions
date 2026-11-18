# Repeated Pattern Check
> GeeksforGeeks · Easy · [problem](https://www.geeksforgeeks.org/problems/the-pattern-matcher/1)

## 📝 Problem

> Given a string s made of two characters of 'x' and 'y'.  The task is to verify whether s is made by concatenating substrings that follow the pattern xnyn (equal number of y's follow equal number of x's).
>
> Examples:
>
> Input: s = "xxyyxy"
> Output: true
> Explanation: The string can be split into "xxyy" + "xy". Both substrings contain an equal number of consecutive 'x' and 'y' characters.
> Input: s = "xyx"
> Output: false
> Explanation: The last 'x' cannot form a valid substring because it is not followed by a matching 'y'.

AnyPush tracked this solution across **1 step**.

## Journey
1. **Step 1 · first solve** _(2026-11-17)_  
   This solution directly parses the input string to verify the "x...xy...y" pattern. It iterates, consuming consecutive 'x's, then consecutive 'y's. For each dete

> ✅ **Merged** — the per-step files were collapsed into `solution.java`. The journey above is the kept record.

## Current solution
See [`solution.java`](./solution.java).
