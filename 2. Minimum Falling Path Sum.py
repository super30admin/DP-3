class Solution:
    def minFallingPathSum(self, matrix) -> int:
        # Time Complexity - O(rows*cols)
        # Space Complexity - O(1) - as we're only modifying the input array

        if matrix == None or len(matrix) == 0:
            return 0

        m = len(matrix)
        n = len(matrix[0])

        for i in range(m - 2, -1, -1):
            for j in range(n):
                # If we're on the left most element of the row
                if j == 0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j + 1])
                # If we're on the right most element of the row
                elif j == n - 1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j - 1])
                # If the element is anywhere in between
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j + 1], matrix[i + 1][j - 1])

        result = 10108758467533456425425

        for i in range(n):
            result = min(result, matrix[0][i])

        return result