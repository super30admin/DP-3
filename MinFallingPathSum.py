# import sys
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if not matrix:
            return 0
        mini=999999
        for i in range(len(matrix)-2, -1, -1):
            for j in range(len(matrix[0])):
                if j == len(matrix[0])-1:
                    matrix[i][j]+= min(matrix[i+1][j], matrix[i+1][j-1])
                elif j == 0:
                    matrix[i][j]+= min(matrix[i+1][j], matrix[i+1][j+1])
                    print(matrix[i][j])
                else:
                    matrix[i][j]+= min(matrix[i+1][j], 
                                       min(matrix[i+1][j+1], matrix[i+1][j-1]))
        for i in range(len(matrix[0])):
            mini = min(mini, matrix[0][i])
        return mini
    
    
    
#         for i in range(len(matrix[0])):
#             globals()[f"case{i}"] = self.helper(matrix, 0, 0, i)
#         mini=99999
#         if not matrix:
#             return 0
#         for i in range(len(matrix[0])):
#             mini=min(mini, globals()[f"case{i}"])
#         return mini
    
#     def helper(self, matrix, Amount, row, col)->int:
#         if row == len(matrix):
#             return Amount
#         if col == len(matrix[0])-1:
#             return min(self.helper(matrix, Amount+matrix[row][col], row+1, col), self.helper(matrix, Amount+matrix[row][col], row+1, col-1))
#         elif col == 0:
#             return min(self.helper(matrix, Amount+matrix[row][col], row+1, col), self.helper(matrix, Amount+matrix[row][col], row+1, col+1))
#         else:               
#             return min(self.helper(matrix, Amount+matrix[row][col], row+1, col), min(self.helper(matrix, Amount+matrix[row][col], row+1, col-1), self.helper(matrix, Amount+matrix[row][col], row+1, col+1)))
#         return 999999

"""Time complexity - O(nm) where n and m are the dimensions of the matrix
space complexity - O(1) using dynamic programming

Recursive approach -- Time complexity - O(n*(3^n)) as we have n columns of the matrix and 
we can pick any element from 1st row, so each element would have 3 possible ways in the worst case.
Space Complexity - O(m)--Not sure"""
        
        
        