class Solution:

    # Dynamic Programming:
    # // Time Complexity :O(N^2)
    # // Space Complexity :O(N^2)
    # // Did this code successfully run on Leetcode : Yes
    # // Any problem you faced while coding this : Nope
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if not matrix:
            return 0
        result = float('inf')
        for i in range(len(matrix) - 2, -1, -1):
            for j in range(len(matrix[0])):
                if j - 1 < 0:
                    dLeft = float('inf')
                else:
                    dLeft = matrix[i + 1][j - 1]
                if j + 1 >= len(matrix[0]):
                    dRight = float('inf')
                else:
                    dRight = matrix[i + 1][j + 1]
                down = matrix[i + 1][j]
                matrix[i][j] = matrix[i][j] + min(down, dLeft, dRight)
        # print(matrix)
        for i in range(0, len(matrix[0])):
            result = min(result, matrix[0][i])
        return result

    # Recursive Approach
    # // Time Complexity :O(N* 3^N)
    # // Space Complexity :O(N)
    # // Did this code successfully run on Leetcode : Yes
    # // Any problem you faced while coding this : Nope
    def helper(self, matrix, r, c):
        if c < 0 or c == len(matrix[0]):
            return float('inf')
        if (r == len(matrix) - 1):
            return matrix[r][c]

        dright = self.helper(matrix, r + 1, c + 1)
        down = self.helper(matrix, r + 1, c)
        dleft = self.helper(matrix, r + 1, c - 1)
        return matrix[r][c] + min(dright, down, dleft)