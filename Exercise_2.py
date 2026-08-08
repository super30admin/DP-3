# Time Complexity : O(n^2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : I had to handle the left and right diagonal edges without going out of bounds.
# Approach: I started from the last row because its falling path cost is already known.
# Moving upward, each cell adds its value to the minimum reachable value from the row below.
# After the top row is processed, the smallest value there is the minimum falling path sum.


class Solution:

    def minFallingPathSum(self, matrix):
        size = len(matrix)
        dp = matrix[-1][:]

        for row in range(size - 2, -1, -1):
            current = [0] * size

            for col in range(size):
                best_next = dp[col]

                if col > 0:
                    best_next = min(best_next, dp[col - 1])

                if col + 1 < size:
                    best_next = min(best_next, dp[col + 1])

                current[col] = matrix[row][col] + best_next

            dp = current

        return min(dp)
