# Time Complexity: O(n x n)
# Space Complexity: O(1)
class Solution(object):
    def minFallingPathSum(self, matrix):

        # Check if matrix is empty
        if len(matrix) == 0:
            return 0
        # Iterate over matrix to get desired result
        for i in range(len(matrix) - 2, -1, -1):
            for j in range(len(matrix[0])):
                # If we are in 1st coulmn then we need to update current matrix element value to current value + minimum between next row same coulmn value and next column value
                if j == 0 and j != len(matrix) - 1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j + 1])
                # Similarly for last column values in matrix we need to update value with its current value + minimum between next row current value and previous column value
                elif (j == len(matrix) - 1):
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j - 1])
                # Hence for rest of the columns in the matrix  we will update vaule with
                # current value + minimum between next row same column, previous column and next column
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j - 1], matrix[i + 1][j + 1], matrix[i + 1][j])

        # We will return result in first row of the matrix whatever is the minimum value
        return min(matrix[0])
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
