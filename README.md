<<<<<<< HEAD
Maximum Dot Product of Two Subsequences (Dynamic Programming)

Problem Description
Given two integer arrays nums1 and nums2, the task is to find the maximum dot product between non-empty subsequences of both arrays having the same length.

A subsequence is formed by deleting zero or more elements from the array without changing the order of the remaining elements.

Approach Used
Dynamic Programming (2D DP)

We use a DP table where:
dp[i][j] represents the maximum dot product using elements from
nums1[0..i-1] and nums2[0..j-1]
At least one pair of elements must be chosen.

Key Ideas:
At every index (i, j), we either pair the current elements or skip one element.
The solution correctly handles cases where all values are negative.

DP Transition Logic
At each position (i, j):
Start a new subsequence using nums1[i-1] * nums2[j-1]
Extend the previous subsequence by adding nums1[i-1] * nums2[j-1]
Skip the current element from nums1
Skip the current element from nums2
The maximum of these choices is stored in dp[i][j].

Complexity Analysis
Time Complexity: O(n × m)
Space Complexity: O(n × m)
Where n and m are the lengths of nums1 and nums2.

Example
Input:
nums1 = [2, 1, -2, 5]
nums2 = [3, 0, -6]

Output:
18

Explanation:
Chosen subsequences are [2, -2] and [3, -6]
Dot product = (2 × 3) + (-2 × -6) = 18

How to Run
Compile the Java file using:
javac Solution.java

Run the program using:
java Solution

Concepts Used
Dynamic Programming
2D DP Table
Subsequence logic
Handling negative values
=======
# leetcode
>>>>>>> 608fab357e1de39fe61893e441a9c123d813ceda
