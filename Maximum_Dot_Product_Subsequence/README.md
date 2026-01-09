Longest Palindromic Subsequence (Java)
📌 Problem Description

Given a string s, find the length of the longest subsequence that is also a palindrome.

A subsequence is a sequence that can be derived from the string by deleting some or no characters without changing the order of the remaining characters.
A palindrome is a string that reads the same forward and backward.

🧠 Approach (Dynamic Programming)
We use Dynamic Programming (DP) to solve this problem efficiently.

Key Idea:
Create a 2D DP array dp[i][j]
dp[i][j] represents the length of the longest palindromic subsequence in the substring s[i…j]

🛠 Algorithm Steps
If the string length is 0, return 0
Initialize a 2D array dp[n][n]
Every single character is a palindrome of length 1
dp[i][i] = 1

Fill the DP table for substrings of length 2 to n
If characters match:
dp[i][j] = 2 + dp[i+1][j-1]

If characters do not match:
dp[i][j] = max(dp[i+1][j], dp[i][j-1])

The final answer is stored in:

dp[0][n-1]

🧪 Example
Input:
s = "bbbab"

Output:
4

Explanation:
The longest palindromic subsequence is "bbbb".