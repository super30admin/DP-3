class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        # Bottom up Dynamic Programming
        # Almost same as Paint house
        n = len(matrix)
        
        for i in range(n - 2, -1, -1):
            for j in range(n):
                
                if j == 0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1])
                    
                elif j == n - 1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j-1])
                    
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], min(matrix[i+1][j-1],matrix[i+1][j+1]))
                    
        return min(matrix[0])
                    
        # Time Complexity: O(n * n) because looping twice in the matrix
        # Space Complexity: O(1) because did the computations on the same matrix which was given