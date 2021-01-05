// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        
        rows, cols = len(A), len(A[0])
        
        dp = [[0 for _ in range(cols)] for _ in range(rows)]
        
        dp[0][0] = A[0][0]
        for i in range(1, rows):
            dp[i][0] = A[i][0]
            
        for j in range(1, cols):
            dp[0][j] = A[0][j]
        for i in range(1, rows):
            for j in range(cols):
                if cols - 1 > j > 0:
                    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1]) + A[i][j]
                elif j > 0:
                    dp[i][j] = min(dp[i-1][j], dp[i-1][j-1]) + A[i][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i-1][j+1]) + A[i][j]
        
        return min(dp[rows-1])