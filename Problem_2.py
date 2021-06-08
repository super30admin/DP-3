from typing import List

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if matrix == None or len(matrix) == 0:
            return 0
        for i in range(1, len(matrix)):
            for j in range(len(matrix)):
                if j == 0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i-1][j], matrix[i-1][j+1])
                elif j == len(matrix) - 1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i-1][j], matrix[i-1][j-1])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i-1][j-1],matrix[i-1][j], matrix[i-1][j+1])
        
        result = float('inf')
        for i in range(len(matrix)):
            result = min(result, matrix[len(matrix)-1][i])
        
        return result

obj = Solution()
print(obj.minFallingPathSum([[2,1,3],[6,5,4],[7,8,9]]))
print(obj.minFallingPathSum([[-19,57],[-40,-5]]))

# Time Complexity : O(n * n)
# Space Complexity : O(1)