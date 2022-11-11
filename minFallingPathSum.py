'''
Time Complexity -->
O(n^2)

Space Complexity-->
O(1) since we are updating the same matrix

'''

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        for i in range(len(matrix)-2, -1, -1):
            for j in range(len(matrix[0])):
                if j==0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                elif j==len(matrix[0])-1:
                    matrix[i][j]+=min(matrix[i+1][j-1], matrix[i+1][j])
                else:
                    matrix[i][j]+=min(matrix[i+1][j-1], matrix[i+1][j], matrix[i+1][j+1])
        return min(matrix[0])
                    
#         ROW = len(matrix)
#         COL = len(matrix[0])
#         ls = []
#         dp = [[-1 for i in range(len(matrix[0]))] for j in range(len(matrix))]
#         for j in range(len(matrix[0])):
#             ls.append(self.Minval(matrix, 0,j,ROW,COL, dp))
#         return min(ls)
    
    
    
#     def isValid(self, i, j, ROW, COL, dp):
#         if i<0 or i>=ROW or j<0 or j>=COL:
#             return False
#         else:
#             return True
    
#     def Minval(self, matrix, i,j, ROW, COL, dp):
#         # print(i,end =' ')
#         # print(j)
#         if i==ROW-1 and j<COL:
#             return matrix[i][j]
        
#         if self.isValid(i,j, ROW, COL, dp):
#             if dp[i][j]!=-1:
#                 return dp[i][j]
            
#             dp[i][j] = matrix[i][j]+min(self.Minval(matrix, i+1, j-1, ROW, COL, dp), self.Minval(matrix, i+1, j, ROW, COL, dp), self.Minval(matrix, i+1, j+1, ROW, COL, dp))
#             return dp[i][j]
#         else:
#             return float('inf')
    
    
        