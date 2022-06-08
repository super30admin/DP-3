'''
Time Complexity : O(m*n) where m and n is rows and columns of the matrix
Space Complexity: O(1)
Run on LeetCode : YES
'''
class Solution:
    def minFallingPathSum(self, matrix: list[list[int]]) -> int:
        for i in range(1,len(matrix)):
            matrix[i][0] += min(matrix[i-1][0],matrix[i-1][1])
            matrix[i][len(matrix[0])-1] += min(matrix[i-1][len(matrix[0])-1],matrix[i-1][len(matrix[0])-2])
            for j in range(1,len(matrix[0]) - 1):
                matrix[i][j] += min(matrix[i-1][j-1],matrix[i-1][j],matrix[i-1][j+1])
        return min(matrix[-1])