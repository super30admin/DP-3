# Time Complexity : O(n^2) where n is the length of the matrix
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        dp = [0] * (len(matrix) + 1)

        # Nested For-Loop takes O(n^2)
        for row in range(len(matrix) - 1, -1, -1):
            curRow = [0] * (len(matrix) + 1)

            for col in range(0, len(matrix)):
                if col == 0:
                    curRow[col] = min(dp[col], dp[col + 1]) + matrix[row][col]
                elif col == (len(matrix) - 1):
                    curRow[col] = min(dp[col], dp[col - 1]) + matrix[row][col]
                else:
                    curRow[col] = min(dp[col], min(dp[col + 1], dp[col - 1])) + matrix[row][col]
            dp = curRow

        minFallSum = math.inf
        # This loop takes O(n)
        for i in range(0, len(matrix)):
            minFallSum = min(minFallSum, dp[i])

        return minFallSum
