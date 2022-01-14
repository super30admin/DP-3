# Time Complexity : O(N*N)
# Space Complexity : O(N*N)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:        
        dp = [[0 for _ in range(len(matrix)+2)] for _ in range(len(matrix)+1)]
        for i in range(1, len(matrix)+1):
            dp[i][0] = sys.maxsize; dp[i][len(matrix)+1] = sys.maxsize # greater than max limit constraint
        
        min_path_len = sys.maxsize
        for i in range(1, len(matrix)+1):
            for j in range(1, len(matrix)+1):
                dp[i][j] = matrix[i-1][j-1] + min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1])
                if i == len(matrix) and min_path_len > dp[i][j]:
                    min_path_len = dp[i][j]
        
        return min_path_len