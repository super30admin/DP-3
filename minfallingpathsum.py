#Executed on leetcode
#time complexity - O(n^2)
#space complexity - O(1)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        for i in range(1, n):
            for j in range(0, n):
                if j == 0:
                    matrix[i][j] = min(matrix[i-1][j], matrix[i-1][j+1]) + matrix[i][j]
                elif j >0 and j < n-1:
                    matrix[i][j] = min(matrix[i-1][j-1], matrix[i-1][j], matrix[i-1][j+1]) + matrix[i][j]
                else: # j == n-1
                    matrix[i][j] = min(matrix[i-1][j-1], matrix[i-1][j]) + matrix[i][j]
        return min(matrix[n-1])
        