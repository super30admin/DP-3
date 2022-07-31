"""


931. Minimum Falling Path Sum

Time Complexity : O(MN)



Space Complexity : O(1)


Did this code successfully run on Leetcode : Yes


There are 3 types of statement based on the condition given:
    - A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.
    
For the First and the last column, its either  j , j+1 for idx 0 or j, j-1 for last col idx

annd rest the value will be :  matrix[i][j] = matrix[i][j] + min(matrix[i+1][j] , matrix[i+1][j-1])
 
Where we are looping the matrrix from the second last row                    

@name: Rahul Govindkumar_RN27JUL2022
"""

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        if(len(matrix)==0):
            return 0
        
       
        m = len(matrix)    #rows
        n = len(matrix[0]) #cols
        
        
        for i in range (m-2, -1,-1):
            for j in range (n):
                
                if j==0:
                    
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j] , matrix[i+1][j+1])
                    
                elif j == n-1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j] , matrix[i+1][j-1])
                    
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j] , min( matrix[i+1][j-1] , matrix[i+1][j+1]))
                    
                    
                    
        return min(matrix[0])