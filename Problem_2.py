# Time Complexity :O(n)
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : Followed approach from the class 
class Solution:    
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        dp = [[sys.maxsize for _ in range(len(matrix[0]))] for _ in range(len(matrix))]
        for c in range(len(matrix[0])):
            dp[0][c] = matrix[0][c]
            
        for r in range(1, len(matrix)):
            for c in range(len(matrix[0])):
                dp[r][c] = min(dp[r][c], matrix[r][c]+dp[r-1][c])
                if c > 0:
                    dp[r][c] = min(dp[r][c], matrix[r][c]+dp[r-1][c-1])
                if c < len(matrix[0])-1:
                    dp[r][c] = min(dp[r][c], matrix[r][c]+dp[r-1][c+1])
        return min(dp[-1])