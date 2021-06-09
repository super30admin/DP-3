# Time Complexity: O(n2)
# Space Complexity: O(1)
# ran on leetcode : Yes
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        # Check if matrix is empty
        if len(matrix) == 0:
            return 0
        # Iterate over matrix to get desired result
        for i in range(len(matrix) - 2, -1, -1):
            for j in range(len(matrix[0])):
                # in first column we can only take one row below or one row below and j+1
                if j == 0 and j != len(matrix) - 1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j + 1])
                # in last column we can only consider one row below and one row below and j-1
                elif j == len(matrix) - 1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j - 1])
                # in other rows we can traverse through all adjacent values in below row
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j - 1], matrix[i + 1][j + 1], matrix[i + 1][j])

        # We will return result in first row of the matrix whatever is the minimum value
        return min(matrix[0])
