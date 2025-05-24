"""
Approach: try all possible ways to get the min path sum. 3 choices at every cell. 
"""
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        dp = [[float("inf") for i in range(n)] for j in range(n)]

        def recurse(row, col):
            if col >= n or col < 0:
                return float("inf")
            if row == n - 1:
                return matrix[row][col]
            
            if dp[row][col] != float("inf"):
                return dp[row][col]
                
            if row == 0:
                ret = float("inf")
                for j in range(n):
                    dp[row][j] = matrix[0][j] + min(recurse(row + 1, j), recurse(row + 1, j - 1), 
                                                    recurse(row + 1, j + 1))
                    ret = min(ret, dp[row][j])
                return ret      
            dp[row][col] =  matrix[row][col] + min(recurse(row + 1, col), recurse(row + 1, col - 1), 
                                                    recurse(row + 1, col + 1)) 
            return dp[row][col]
        ret= recurse(0, 0)
        return ret