# Time Complexity : O(n*m) where n is the number of rows and m is the number of columns
# Space Complexity : O(1) since we are modifying the input matrix
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
This code solves the problem by starting from 
falling sum for each cell and then iterating to the top row.
"""

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if matrix == None or len(matrix) == 0:
            return  0

        if len(matrix) == 1:
            return min(matrix[0])
        
        for i in range(len(matrix)-2, -1, -1):
            for j in range(len(matrix[0])-1, -1, -1):
                left = sys.maxsize if j == 0 else matrix[i][j] + matrix[i+1][j-1]
                mid = matrix[i][j] + matrix[i+1][j]
                right = sys.maxsize if j == len(matrix[0]) - 1 else matrix[i][j] + matrix[i+1][j+1]

                matrix[i][j] = min(left, mid, right)

        minsum = sys.maxsize
        for i in range(len(matrix)):
            minsum = min(minsum, matrix[0][i])

        return minsum