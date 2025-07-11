# Time Complexity : It is O(N2) looping through matrix of n*n.
# Space Complexity : There is no extra space so it O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

from typing import List

class Solution:
           
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        rowLen = len(matrix) -1
        colLen = len(matrix[0]) -1       
        total=0    
       
        if rowLen ==0:
            return matrix[rowLen][colLen]
        
        for row in range(rowLen-1,-1,-1):
            rowMinVal=99999999999            
            for col in range(colLen+1):
          
                matrix[row][col]= self.findTheMinNeighbour(matrix,row,col) # + matrix[row+1][col]               
                rowMinVal=min(matrix[row][col],rowMinVal)                
            total =rowMinVal  
        return total
       
    def findTheMinNeighbour(self, matrix: List[List[int]],row:int, col:int) -> int:
        if col ==0:
            rowVal =min(matrix[row+1][col],matrix[row+1][col+1]) + matrix[row][col] 
        elif col ==len(matrix)-1:
            rowVal = min(matrix[row+1][col],matrix[row+1][col-1]) + matrix[row][col]
        else:
            rowVal = min(matrix[row+1][col],matrix[row+1][col-1],matrix[row+1][col+1]) + matrix[row][col]
        return rowVal

        
obj = Solution()
print(obj.minFallingPathSum([[-48]]))

#print(obj.minFallingPathSum([[2,1,3],[6,5,4],[7,8,9]]))
# print(obj.minFallingPathSum([[-19,57],[-40,-5]]))
