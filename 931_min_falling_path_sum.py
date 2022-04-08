class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        d1 = len(matrix)
        d2 = len(matrix[0])
        
#         if d2==1: import numpy as np; return np.sum(np.array(matrix))
#         if d1==1: return min(matrix[0])
        
        minSum = [[0 for i in range(d2)] for j in range(d1)]
        
        for t in range(d2): minSum[0][t] = matrix[0][t]
        
        for j in range(1, d1):
            row = matrix[j]
            for i in range(d2):
                if i==0 :
                    minSum[j][i] = matrix[j][i] + min(minSum[j-1][i] ,  minSum[j-1][i+1])
                
                elif i==len(row)-1:
                    minSum[j][i] = matrix[j][i] + min(minSum[j-1][i] , minSum[j-1][i-1])
                    
                else:
                    minSum[j][i] = matrix[j][i] + min(minSum[j-1][i],minSum[j-1][i-1],minSum[j-1][i+1])

                    
        return min(minSum[len(matrix)-1])