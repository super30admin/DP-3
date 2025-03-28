from typing import List

# Time Complexity: O(m*n), where m = number of columns and n = number of rows in the matrix
# Space Complexity: O(m*n), where m = number of columns and n = number of rows in the matrix
# Did this code run successfully on Leetcode: Yes
# Any problem you faced while coding this : Slight difficulty in understanding why we need a separate tree for each starting element
# Approach:
# For each element, we have to choose between either elements directly below it, or diagonally below it.
# 1. We initialize a DP matrix (res) and fill up the last row with the same elements as in the original matrix, as we don't have a minimum choice on the last row.
# 2. Moving upward, for each element, the subproblem of choosing the minimum in the next row is already solved, so we choose minimum from the row directly below it.
# 3. Moving in this fashion, we can get the minimum path sum by getting the minimum on the top row of the result matrix.
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        # let's code the DP approach
        rows, cols = len(matrix), len(matrix[0])
        # Initialize the result matrix
        res = [[0 for _ in range(cols)] for _ in range(rows)]
        
        for i in range(rows-1, -1, -1):
            for j in range(cols):
                # filling up the last row with elements in last row of matrix
                if i == rows-1:
                    res[i][j] = matrix[i][j]
                # If we are on the 0th column, we can only choose from the element directly below it or on the right diagonal.
                elif j == 0:
                    res[i][j] = matrix[i][j] + min(res[i+1][j], res[i+1][j+1])
                # If we are on the last column, we can only choose from the element directly below it or on the left diagonal.
                elif j == cols-1:
                    res[i][j] = matrix[i][j] + min(res[i+1][j], res[i+1][j-1])
                # If we are in the middle, we can move left, right or diagonally down
                else:
                    res[i][j] = matrix[i][j] + min(res[i+1][j+1], res[i+1][j], res[i+1][j-1])
        # Finally, return the minum from the top row
        return min(res[0])

# Recursive approach
# Time Complexity: O(m*2^n) where n is the length of the matrix, and m is the number of columns
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : No, Time Limit Exceeded
# Approach:
# For each element in the first row, we calculate the minimum falling path sum by recursively calculating the minimum
# falling path sum for the next row. We keep track of the path sum and the current element in the row. We return the
# minimum of the three possible paths. We repeat this for all elements in the first row and return the minimum of all
# the paths.
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        # let's code the recursive approach
        def fallingPath(i, fp, pathSum):
            # base case
            if i == len(matrix):
                return pathSum

            # If the element is at the first column, we can only move right or diagonally down
            if fp == 0:
                return min(fallingPath(i+1, fp, pathSum + matrix[i][fp]),
                            fallingPath(i+1, fp+1, pathSum + matrix[i][fp]))
            # If the element is at the last column, we can only move left or diagonally down
            elif fp == len(matrix)-1:
                return min(fallingPath(i+1, fp, pathSum + matrix[i][fp]),
                            fallingPath(i+1, fp-1, pathSum + matrix[i][fp]))
            # If the element is in the middle, we can move left, right or diagonally down
            else:
                return min(fallingPath(i+1, fp, pathSum + matrix[i][fp]),
                            fallingPath(i+1, fp-1, pathSum + matrix[i][fp]),
                            fallingPath(i+1, fp+1, pathSum + matrix[i][fp]))

        # Initialize the minimum path sum to infinity
        res = float('inf')
        # For each element in the first row, calculate the minimum falling path sum
        for i in range(len(matrix)):
            res = min(res, fallingPath(0, i, 0))
        # Return the minimum falling path sum
        return res