'''

Time Complexity : O(n^2)
Space Complexity : O(n^2)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

For each element in the matrix I find the minimum distance to get there

'''


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        row = len(matrix)
        col = len(matrix[0])
        minpath = [[0 for i in range(col)] for i in range(row)]

        minpath[0] = matrix[0]

        for i in range(1,row):
            for j in range(col):

                if j == 0:
                    minpath[i][j] = matrix[i][j] + min(minpath[i-1][j],minpath[i-1][j+1])

                elif j == row - 1:
                    minpath[i][j] = matrix[i][j] + min(minpath[i-1][j],minpath[i-1][j-1])

                else:
                    minpath[i][j] = matrix[i][j] + min(minpath[i-1][j],minpath[i-1][j-1],minpath[i-1][j+1])

        return min(minpath[-1])