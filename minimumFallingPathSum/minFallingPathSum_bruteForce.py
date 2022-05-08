class Solution:
    
    def getMinSum(self,matrix,col,row=0):
        
        # base condition
        if row>=len(matrix):
            return 0
        
        # logic condition
        if col ==0:
            # go-to col 0,1
            return min(self.getMinSum(matrix,col,row+1),
                       self.getMinSum(matrix,col+1,row+1)) + matrix[row][col]
        
        elif col == len(matrix[0])-1:
            # go-to col (currentCol, currentCol-1)
            return min(self.getMinSum(matrix,col-1,row+1),
                       self.getMinSum(matrix,col,row+1)) + matrix[row][col]
        
        else:               
            # go-to col (currentCol-1, currentCol, currentCol+1)
            return min(self.getMinSum(matrix,col-1,row+1),
                       self.getMinSum(matrix,col,row+1),
                       self.getMinSum(matrix,col+1,row+1)) + matrix[row][col]
                       
    def getSolution(self,matrix):
        
        cols = len(matrix[0])
        
        # Result list to store results
        resultList = [None] * cols
        
        # Iterete the list
        for j in range(0,cols):
            resultList[j] = self.getMinSum(matrix,j)
        
        print(min(resultList))
        
sol = Solution()
sol.getSolution([
        [2,1,3],
        [6,5,4],
        [7,8,9]
    ])