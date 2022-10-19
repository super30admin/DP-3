#Time Complexity - O(m * n)
#Space Complexity - O(1) 

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        minElement = float('inf')
        if len(matrix) == 1:
            return matrix[0][0]
        for i in range(1, len(matrix)):
            for j in range(len(matrix)):
                matrix[i][j] += min(
                                matrix[i-1][j] ,
                                matrix[i-1][j-1] if j-1 >= 0 else float('inf'),
                                matrix[i-1][j+1] if j+1 < len(matrix) else float('inf')
                )
                if i == len(matrix) - 1:
                    minElement = min(minElement, matrix[i][j])
        return minElement