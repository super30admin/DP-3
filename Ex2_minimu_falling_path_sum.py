# Time Complexity : O(n^2), where n = len(matrix)
# Space Complexity : O(n), for the space optimized dp array
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        next_row = matrix[n-1][:]  # copy last row

        # Process from second last row up to first row
        for r in range(n-2, -1, -1):
            current_row = [0] * n
            for c in range(n):
                down = next_row[c]
                down_left = next_row[c-1] if c - 1 >= 0 else float('inf')
                down_right = next_row[c+1] if c + 1 < n else float('inf')

                current_row[c] = matrix[r][c] + min(down, down_left, down_right)
            next_row = current_row  # move up

        return min(next_row)


        # -------------------------------
        # Tabulation (Bottom-up DP)
        # Time Complexity: O(n^2), Space Complexity: O(n^2)
        # n = len(matrix)
        # dp = [[0]*n for _ in range(n)]
        # for c in range(n):
        #     dp[n-1][c] = matrix[n-1][c]
        # for r in range(n-2, -1, -1):
        #     for c in range(n):
        #         down = dp[r+1][c]
        #         down_left = dp[r+1][c-1] if c-1 >= 0 else float('inf')
        #         down_right = dp[r+1][c+1] if c+1 < n else float('inf')
        #         dp[r][c] = matrix[r][c] + min(down, down_left, down_right)
        # return min(dp[0])



        # -------------------------------
        # Memoization (Top-down DFS with caching)
        # Time Complexity: O(n^2), Space Complexity: O(n^2)
        # n = len(matrix)
        # memo = [[None] * n for _ in range(n)]
        # def dfs(row, col):
        #     if col < 0 or col >= n:
        #         return float('inf')
        #     if row == n-1:
        #         return matrix[row][col]
        #     if memo[row][col] is not None:
        #         return memo[row][col]
        #     down_left = dfs(row+1, col-1)
        #     down = dfs(row+1, col)
        #     down_right = dfs(row+1, col+1)
        #     memo[row][col] = matrix[row][col] + min(down_left, down, down_right)
        #     return memo[row][col]
        # min_path_sum = float('inf')
        # for c in range(n):
        #     min_path_sum = min(min_path_sum, dfs(0, c))
        # return min_path_sum

        

        # -------------------------------
        # Naive recursive approach (no memo)
        # Time Complexity: Exponential, Space Complexity: O(n) recursion stack
        # n = len(matrix)
        # def dfs(row, col):
        #     if col < 0 or col >= n:
        #         return float('inf')
        #     if row == n-1:
        #         return matrix[row][col]
        #     down_left = dfs(row+1, col-1)
        #     down = dfs(row+1, col)
        #     down_right = dfs(row+1, col+1)
        #     return matrix[row][col] + min(down_left, down, down_right)
        # min_path_sum = float('inf')
        # for c in range(n):
        #     min_path_sum = min(min_path_sum, dfs(0, c))
        # return min_path_sum


if __name__ == "__main__":
    sol = Solution()
    print(sol.minFallingPathSum([[2,1,3],[6,5,4],[7,8,9]]))        # Output: 13
    print(sol.minFallingPathSum([[-19,57],[-40,-5]]))             # Output: -59
    print(sol.minFallingPathSum([[100]]))                         # Output: 100
