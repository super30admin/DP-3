# Time Complexity - O(mn)
# Space Complexity - O(mn)

class Solution:
    
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        dp = matrix[0][:] 
        temp = [0] * len(matrix[0]) 
        for i in range(1, len(matrix)):
            for j in range(len(matrix[0])):
                if j-1<0:
                    left = float('inf')
                else:
                    left = dp[j-1]
                if j+1>=len(matrix[0]):
                    right = float('inf')
                else:
                    right = dp[j+1]
                top = dp[j] 
                temp[j] = min(left, right, top) + matrix[i][j] 
            dp = temp[:] 
        return min(dp) 
