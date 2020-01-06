# Time complexity: O(N^2)
# Space complexity: O(N^2)
# Compiled successfully on leetcode: Yes

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int: 
        rows, cols = (len(A), len(A[0]))
        dp = [[0 for i in range(cols)] for j in range(rows)] 
        
        dp[0] = A[0] 
        for i in range(1, rows):
            for j in range(cols):
                dp[i][j] += A[i][j]
                if j == 0:
                    dp[i][j] += min(dp[i - 1][j], dp[i - 1][j + 1])
                elif j == cols - 1:
                    dp[i][j] += min(dp[i - 1][j], dp[i - 1][j - 1])
                else:
                    dp[i][j] += min(dp[i - 1][j], dp[ i -1][j -1], dp[i - 1][j + 1])
                    
        return min(dp[rows - 1])