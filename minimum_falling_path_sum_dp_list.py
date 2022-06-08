# Time Complexity : O(N * N) where N is number columns annd rows in the matrix
# Space Complexity : O(N) when N is number of columns in the matrix
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        predp, dp = [float('inf') for _ in range(len(matrix[0]))], [float('inf') for _ in range(len(matrix[0]))]
        dirs = [[-1, -1], [-1, 0], [-1, 1]]
        for i, num in enumerate(matrix[0]):
            predp[i] = num
                
        for i in range(1, len(matrix)):
            for j in range(0, len(matrix[0])):
                for d in dirs:
                    cp = j + d[1]
                    if cp >= 0 and cp < len(matrix[0]):
                        if dp[j] > predp[cp] + matrix[i][j]:
                            dp[j] = predp[cp] + matrix[i][j]
            predp = dp[:]
            dp = [float('inf') for _ in range(len(matrix[0]))]
                
        minSum = float('inf')
        for i in range(len(predp)):
            if minSum > predp[i]:
                minSum = predp[i]
                
        return minSum