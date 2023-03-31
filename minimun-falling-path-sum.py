# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
"""
Start from the second last row and take the minimum of last row. Follow this till the top row.
Get the minumum of top row
"""


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:

        if not matrix:
            return False
        n = len(matrix)
        for i in range(n - 2, -1, -1):
            for j in range(n):

                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j],matrix[i+1][j+1])
                elif j == n-1:
                    matrix[i][j] += min(matrix[i+1][j],matrix[i+1][j-1])
                else:
                    matrix[i][j] += min(matrix[i+1][j-1],matrix[i+1][j],matrix[i+1][j+1])

        return min(matrix[0])
