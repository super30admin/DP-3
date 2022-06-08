# Time Complexity : O(N * N) where N is number columns annd rows in the matrix
# Space Complexity : O(N*N) when N is size of the matrix
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        dp = [[float('inf') for _ in range(len(matrix[0]))] for _ in range(len(matrix))]
        dirs = [[-1, -1], [-1, 0], [-1, 1]]
        for i, num in enumerate(matrix[0]):
            dp[0][i] = num
                
        for i in range(1, len(matrix)):
            for j in range(0, len(matrix[0])):
                for d in dirs:
                    rp = i + d[0] 
                    cp = j + d[1]
                    if cp >= 0 and cp < len(matrix[0]):
                        if dp[i][j] > dp[rp][cp] + matrix[i][j]:
                            dp[i][j] = dp[rp][cp] + matrix[i][j]
                
        minSum = float('inf')
        for i in range(len(dp[0])):
            if minSum > dp[len(dp) - 1][i]:
                minSum = dp[len(dp) - 1][i]
                
        return minSum