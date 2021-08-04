"""
Time Complexity : O(mn) 
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
import sys
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        # Mutate matrix according to the mini element like in Pain House prob
        for i in range(1, m):
            for j in range(n):
                if j == 0:
                    matrix[i][j] += min(matrix[i - 1][j], matrix[i - 1][j + 1])
                elif j == n - 1:
                    matrix[i][j] += min(matrix[i - 1][j], matrix[i - 1][j - 1])
                else:
                    matrix[i][j] += min(matrix[i - 1][j], matrix[i - 1][j - 1],                             matrix[i - 1][j + 1])
        mini = sys.maxsize
        # Answer lies in last row so I need to itereate through all
        # columns of last row
        for i in range(n):
            mini = min(mini, matrix[m - 1][i])
        return mini