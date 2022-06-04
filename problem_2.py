# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach

class Solution:
    def minFallingPathSum(self, matrix: list[list[int]]) -> int:
        for i in range(len(matrix)-2, -1, -1):
            for j in range(len(matrix[0])):
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == len(matrix[0]) - 1:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j-1], matrix[i+1][j], matrix[i+1][j+1])
        return min(matrix[0])


check = Solution()
print(check.minFallingPathSum([[2, 1, 3], [6, 5, 4], [7, 8, 9]]))

# Recursive approach - Time Limit Exceeded
# class Solution:
#     def helper(self, matrix, row, column, sum):
#         if row == len(matrix) or column == len(matrix[0]):
#             return sum
#         if column == 0:
#             case1 = self.helper(matrix, row + 1, column, sum + matrix[row][column])
#             case2 = self.helper(matrix, row + 1, column + 1, sum + matrix[row][column])
#             return min(case1, case2)
#         elif column == len(matrix) - 1:
#             case1 = self.helper(matrix, row + 1, column, sum + matrix[row][column])
#             case2 = self.helper(matrix, row + 1, column - 1, sum + matrix[row][column])
#             return min(case1, case2)
#         else:
#             case0 = self.helper(matrix, row + 1, column + 1, sum + matrix[row][column])
#             case1 = self.helper(matrix, row + 1, column, sum + matrix[row][column])
#             case2 = self.helper(matrix, row + 1, column - 1, sum + matrix[row][column])
#             return min(case0, case1, case2)

#     def minFallingPathSum(self, matrix: list[list[int]]) -> int:
#         temp = []
#         for i in range(len(matrix)):
#              temp.append(self.helper(matrix, 0, i, 0))
#         return min(temp)
#
#
# check = Solution()
# print(check.minFallingPathSum([[2, 1, 3], [6, 5, 4], [7, 8, 9]]))
