#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Feb 22 13:32:07 2026

@author: rishigoswamy

    LeetCode 931: Minimum Falling Path Sum
    Link: https://leetcode.com/problems/minimum-falling-path-sum/

    Approach:
    Dynamic Programming (row by row).

    Let prev[j] = minimum falling path sum to reach column j in the previous row.
    For the current row i and column j:
        curr[j] = matrix[i][j] + min(prev[j], prev[j-1], prev[j+1])
    (only include neighbors that are in bounds)

    We only need the previous row to compute the current row, so we use O(n) extra space.

    // Time Complexity : O(n^2)
        n = number of rows = number of columns (square matrix)
        Each cell computed once with O(1) work.
    // Space Complexity : O(n)
        prev and curr arrays of length n.

"""

from typing import List


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        temp = []
        prev = matrix[0]
        for i in range(1, len(matrix)):
            temp = []
            temp.append(
                matrix[i][0] + 
            min(prev[0], prev[1]))
            for j in range(1, len(matrix) - 1):
                temp.append(matrix[i][j]+ min(prev[j-1],
                prev[j],
                prev[j+1]))
            temp.append(matrix[i][-1] + min(prev[-1], prev[-2]))
            prev = temp
        return min(prev)
            


        