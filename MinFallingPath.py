# Time Complexity: O(m*n); m=row count, n= col count
# Space Complexity: O(1)
 
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        for i in range(len(matrix)-2, -1, -1):
            for j in range(len(matrix[0])):
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == len(matrix[0]) - 1:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1], matrix[i+1][j+1])
        
        res = 99999
        for j in range(len(matrix[0])):
            res = min(res, matrix[0][j])
            
        return res
                
            
        
        
