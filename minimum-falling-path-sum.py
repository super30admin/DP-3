''' Time Complexity : O(n * n) ;
    Space Complexity : O(n * n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

'''
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        rows, cols = len(matrix), len(matrix[0])
        dp = [[0 for _ in range(cols)] for _ in range(rows)]
        print(dp)
        for j in range(cols):
            dp[0][j] = matrix[0][j]

        for i in range(1,rows):
            for j in range(cols):
                if j == 0 :
                    dp[i][j] = min((matrix[i][j] + dp[i-1][j]), matrix[i][j] + dp[i-1][j+1])                    
                elif j == cols - 1:
                    dp[i][j] = min((matrix[i][j] + dp[i-1][j]), matrix[i][j] + dp[i-1][j-1])
                else:
                    dp[i][j] = min((matrix[i][j] + dp[i-1][j-1]),(matrix[i][j] + dp[i-1][j]), (matrix[i][j] + dp[i-1][j+1]))
        return min(dp[rows-1])