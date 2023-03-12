# Time Complexity :  O(n^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix) - 1
        minimum = sys.maxsize
        if len(matrix) == 1:
            return min(matrix[0])
        for i in range(n-1,-1,-1):
            for j in range(n,-1,-1):
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == n:
                     matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] += min(matrix[i+1][j-1], matrix[i+1][j], matrix[i+1][j+1])
        return min(matrix[0])
