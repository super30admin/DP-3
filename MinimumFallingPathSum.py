# Time complexity: O(n^2) with help of memoization
# Space: O(n^2) memo size

# The intuition is simple, iterate through the first row and do a dfs in the directions mentioned and get the min value and add it to the current.
class Solution:
    def minFallingPathSumRecursive(self, matrix: List[List[int]]) -> int:

        self.n = len(matrix)
        self.total = float("inf")
        self.memo = {}

        def dfs(row, col):
            if col < 0 or col >= self.n:
                return float("inf")
            if row == self.n:
                return 0
            if (row, col) in self.memo:
                return self.memo[(row, col)]
            curr = matrix[row][col]
            leftDiag = dfs(row + 1, col - 1)
            down = dfs(row + 1, col)
            rightDiag = dfs(row + 1, col + 1)
            self.memo[(row, col)] = curr + min(leftDiag, down, rightDiag)
            return self.memo[(row, col)]

        for c in range(self.n):
            self.total = min(self.total, dfs(0, c))

        return self.total

    # Time complexity: O(n^2) iterating through row and col
    # Space: O(n^2) dp matrix
    # The intuition is same with a bottom up approach. Get current value plus min of all the other direction(bottom, diag left and diag right)
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        dp = [[0 for _ in range(n+1)] for _ in range(n+1)]
        for r in range(n+1):
            dp[r][n] = float("inf")
        for r in range(n - 1, -1, -1):
            for c in range(n - 1, -1, -1):
                dp[r][c] = matrix[r][c] + min(dp[r + 1][c - 1], dp[r + 1][c], dp[r + 1][c + 1])
        minTotal = float("inf")
        for c in range(n):
            minTotal = min(minTotal, dp[0][c])

        return minTotal
