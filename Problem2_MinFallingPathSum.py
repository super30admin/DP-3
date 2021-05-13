# Time Complexity: O(n * n), where n = num of rows = num of cols
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Solution:

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if not matrix or len(matrix) == 0:
            return 0

        n = len(matrix)

        # Update the min sum along all possible paths of the matrix
        for i in range(1, n):
            for j in range(n):
                if j == 0:
                    matrix[i][j] += min(matrix[i - 1][j], matrix[i - 1][j + 1])
                elif j == n - 1:
                    matrix[i][j] += min(matrix[i - 1][j], matrix[i - 1][j - 1])
                else:
                    matrix[i][j] += min(matrix[i - 1][j], min(matrix[i - 1][j - 1], matrix[i - 1][j + 1]))

        # Find the overall minimum sum of all falling paths from the last row
        minimum = float('inf')
        for j in range(n):
            minimum = min(minimum, matrix[n - 1][j])

        return minimum
