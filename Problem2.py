# https://leetcode.com/problems/unique-paths/description/

# exhaustive approach
# TC: 2^(m+n)
# SC: O(m+n)
class Solution:
    count = 0
    def uniquePaths(self, m: int, n: int) -> int:
        self.helper(0, 0, m, n)
        return self.count

    def helper(self, i, j, m, n):

        if i == m-1 and j == n-1:
            self.count += 1
            return

        if i == m or j == n:
            return

        # move right
        self.helper(i, j+1, m, n)

        # move down
        self.helper(i+1, j, m, n)


# int based recursion
class Solution:
    count = 0
    def uniquePaths(self, m: int, n: int) -> int:
        return self.helper(0, 0, m, n)

    def helper(self, i, j, m, n):

        if i == m-1 and j == n-1:
            return 1

        if i == m or j == n:
            return 0

        # move right
        case0 = self.helper(i, j+1, m, n)

        # move down
        case1 = self.helper(i+1, j, m, n)

        return case0 + case1
    
# DP solution with memoization using 2d matrix
# TC: O(m*n)
# SC: O(m*n)
class Solution:
     
    def uniquePaths(self, m: int, n: int) -> int:
        self.memo = [[0] * n for _ in range(m)]
        return self.helper(0, 0, m, n)

    def helper(self, i, j, m, n):

        if i == m-1 and j == n-1:
            return 1

        if i == m or j == n:
            return 0

        if self.memo[i][j] != 0: return self.memo[i][j]

        # move right
        case0 = self.helper(i, j+1, m, n)

        # move down
        case1 = self.helper(i+1, j, m, n)

        self.memo[i][j] = case0 + case1

        return case0 + case1
    
# DP with tabulation (bottom-up)
# TC: O(m*n)
# SC: O(m*n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:

        dp = [[0] * n for _ in range(m)]

        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                if i == m-1 or j == n-1:
                    dp[i][j] = 1
                else:
                    dp[i][j] = dp[i+1][j] + dp[i][j+1]

        return dp[0][0]
    
# DP with tabulation (top-down)
# TC: O(m*n)
# SC: O(m*n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:

        dp = [[0] * n for _ in range(m)]

        for i in range(m):
            for j in range(n):
                if i == 0 or j == 0:
                    dp[i][j] = 1
                else:
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]

        return dp[m-1][n-1]
    
# DP with 1D array
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:

        dp = [0] * n 

        for i in range(m):
            for j in range(n):
                if i == 0 or j == 0:
                    dp[j] = 1
                else:
                    dp[j] = dp[j] + dp[j-1]

        return dp[n-1]