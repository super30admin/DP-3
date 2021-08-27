# Did this code successfully run on Leetcode : YES

# TC: O(N*N)
# SC: O(N*N)

# approach
# paint house approach
# except here indices are not limited to three but immediate neighbors and self index


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        dp = [[0 for _ in range(n)] for _ in range(n)]

        dp[0] = matrix[0]

        for r in range(1, n):
            for c in range(n):
                if c == 0:
                    dp[r][c] = matrix[r][c] + min(dp[r-1][c], dp[r-1][c+1])
                elif c == n-1:
                    dp[r][c] = matrix[r][c] + min(dp[r-1][c], dp[r-1][c-1])
                else:
                    dp[r][c] = matrix[r][c] + min(dp[r-1][c], dp[r-1][c+1], dp[r-1][c-1])

        # print(dp)
        
        return min(dp[-1])