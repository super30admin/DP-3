"""
TC: O(N^2) {With memoization, we only iterate once through all the matrix and store the repeated sub problems}
SC: O(N^2) {we use a cache dictionary to store the repeated sub problem solutions}

Approach:
We iterate through all the cols of the first row and then iteratively calculate the minimum falling path sum from that idx, col.
Since we can only go for the directly below and +1 -1 of that col index, we use a for loop to do that in the helper function.
We then return the min falling path sum from each call.
We also use the memoization technique to save the repeated problems occuring, thus saving compute by retreiving the answer from
that sub-problem whenever needed.

The problem ran successfully on Leetcode.
"""

from typing import List

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        cache = {}
        def helper(i, j):
            if i == row:
                return 0

            if (i, j) in cache:
                return cache[(i,j)]

            case1 = float("inf")

            for k in range(max(0, j-1), min(col, j+2)):
                case1 = min(case1, helper(i+1, k))
            
            cache[(i,j)] = case1 + matrix[i][j]
            return cache[(i,j)]

        
        row = col = len(matrix)
        
        res = float("inf")
        for j in range(col):
            res = min(res, helper(0, j))
        return res