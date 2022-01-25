# Leetcode Execution: YES
# Time Complexity: O(m*n)
# Space Complsity:O(1)

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        # using mutating the given matrix in place 
        # we get the min value from the given 2 to three option from below row and add to the current row and col value and do this for all the value from row-1 to 0 row and all colums
        
        # finally return the min of first row values
        
        for i in range(len(matrix)-2, -1,-1):
            for j in range(len(matrix[0])):
                if j==0:
                    matrix[i][j]+=min(matrix[i+1][j],matrix[i+1][j+1])
                elif j>0 and j<len(matrix[i])-1:
                    matrix[i][j]+=min(matrix[i+1][j],min(matrix[i+1][j+1], matrix[i+1][j-1]))
                elif j==len(matrix[i])-1:
                     matrix[i][j]+=min(matrix[i+1][j],matrix[i+1][j-1])
        m=float('inf')
        for i in range(len(matrix[0])):
            m=min(m, matrix[0][i])
        return m
        
        
        
        
        
        
        
        
#         Leetcode Execution: YES
# Time Complexity: O(m*n)
# Space Complsity:O(m*n)
        # using new matrix
#         dp= [[0 for _ in range(len(matrix[0]))] for x in range(len(matrix))]
#         dp[len(matrix)-1]=matrix[len(matrix)-1]
#         for i in range(len(matrix)-2, -1,-1):
#             for j in range(len(matrix[0])):
#                 if j==0:
#                     dp[i][j]=matrix[i][j]+min(dp[i+1][j],dp[i+1][j+1])
#                 elif j>0 and j<len(matrix[i])-1:
#                     dp[i][j]=matrix[i][j]+min(dp[i+1][j],min(dp[i+1][j+1], dp[i+1][j-1]))
#                 elif j==len(matrix[i])-1:
#                      dp[i][j]=matrix[i][j]+min(dp[i+1][j],dp[i+1][j-1])
                        
#         m=float('inf')
#         for i in range(len(matrix[0])):
#             m=min(m, dp[0][i])
#         return m
                    
                
                    
        