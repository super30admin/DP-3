# Minimum Falling Path Sum
'''
Leetcode all test cases passed: Yes
Solution:
    choice(self,matrix,i,j,no_of_columns):
        Space Complexity: O(1)
        Time Complexity: O(1)
    minFallingPathSum(self, matrix)
        m is no of rows in matrix
        n is no of columns in matrix
        Space Complexity: O(1)
        Time Complexity: O(m * n)
'''

class Solution:
    def choice(self,matrix,i,j,no_of_columns):
        left = right = float("inf")
        center = matrix[i + 1][j] + matrix[i][j]
        if j - 1 >= 0:
            left = matrix[i + 1][j -1] + matrix[i][j]
        if j + 1 < no_of_columns:
            right = matrix[i + 1][j +1] + matrix[i][j]
        return min(left,center,right)
    
    def minFallingPathSum(self, matrix):
        for i in range(len(matrix) - 2 ,-1, -1):
            for j in range(len(matrix[0])):
                matrix[i][j] = self.choice(matrix,i,j,len(matrix[0]))
        return min(matrix[0])
