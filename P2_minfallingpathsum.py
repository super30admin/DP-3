"""
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
"""

class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        n = len(matrix)

        # Start from second-last row and move upward
        for i in range(n - 2, -1, -1):  # go from n-2 to 0
            for j in range(n):
                # Get the 3 possible paths from below row
                down = matrix[i + 1][j]                      # ↓
                left = matrix[i + 1][j - 1] if j > 0 else float('inf')   # ↙
                right = matrix[i + 1][j + 1] if j < n - 1 else float('inf')  # ↘

                # Add current cell value to the minimum of the 3
                matrix[i][j] += min(down, left, right)

        # The answer is the smallest value in the first row
        return min(matrix[0])
