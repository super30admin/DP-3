class Solution:
    
    def getMinSum(self,matrix):
        
        # original matrix to be mutated
        
        for i in range(0,len(matrix)):
            
            if i == 0:
                continue
            
            else:
                # Iterate the cols
                for j in range(0,len(matrix[i])):
                    
                    if j == 0:
                        matrix[i][j] += min(matrix[i-1][j],matrix[i-1][j+1])
                    
                    elif j == len(matrix[i])-1:
                        matrix[i][j] += min(matrix[i-1][j],matrix[i-1][j-1])
                    
                    else:
                        matrix[i][j] += min(matrix[i-1][j-1],matrix[i-1][j],matrix[i-1][j+1])
        
        return matrix
    def getSolution(self,matrix):
        
        # Mutate the matrix way
        mutatedMatrix = self.getMinSum(matrix)
        return min(mutatedMatrix[-1])
        
sol = Solution()
print(sol.getSolution([
        [2,1,3],
        [6,5,4],
        [7,8,9]
    ]))