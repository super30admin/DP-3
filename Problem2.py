"""
931. Minimum Falling Path Sum
Time Complexity - O(n*m)
Space Complexity - O(1)
Here we are finding optimal solution starting from row=1 and most optimal solution from last row will be our solution"""

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if matrix == None or len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        
        n = len(matrix)
        m = len(matrix[0])
        
        "Finding minimum way to get an optimal solution"
        for i in range(1,n):
            for j in range(0,m):
                if j == 0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i-1][j],matrix[i-1][j+1])
                elif j == m-1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i-1][j],matrix[i-1][j-1])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i-1][j],matrix[i-1][j+1],matrix[i-1][j-1])
        
        "Find most optimal solution from last row"
        min_val = float("inf")
        for x in matrix[n-1]:
            if x < min_val:
                min_val = x
        
        return min_val