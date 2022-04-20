# Time complexity -> O(n)
# Space complexity -> O(1)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if not matrix:
            return 0
        
        for i in range(len(matrix) - 2, -1,-1):
            for j in range(0,len(matrix[0])):
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])  
                elif j == len(matrix[0])-1:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
                else:     
                    matrix[i][j] += min(matrix[i+1][j+1],matrix[i+1][j-1],matrix[i+1][j])
                    
        
        return min(matrix[0])