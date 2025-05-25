# Recursion
# Time Complexity: O(3^n)
# Space Complexity: O(n)

def minFallingPathSum(matrix):
    n = len(matrix)
    def recursive_min_falling_path_sum(i, j):
        if i == n:
            return 0
        if j < 0 or j >= n:
            return float('inf')
        return matrix[i][j] + min(recursive_min_falling_path_sum(i + 1, j - 1),
                                  recursive_min_falling_path_sum(i + 1, j),
                                  recursive_min_falling_path_sum(i + 1, j + 1))

    return min(recursive_min_falling_path_sum(0, j) for j in range(n))

# Memoization
# Time Complexity: O(n^2)
# Space Complexity: O(n^2)

def minFallingPathSum(matrix):
    n = len(matrix)
    memo = {}
    def recursive_min_falling_path_sum(i, j):
        if (i, j) in memo:
            return memo[(i, j)]
        if i == n:
            return 0
        if j < 0 or j >= n:
            return float('inf')
        memo[(i, j)] = matrix[i][j] + min(recursive_min_falling_path_sum(i + 1, j - 1),
                                          recursive_min_falling_path_sum(i + 1, j),
                                          recursive_min_falling_path_sum(i + 1, j + 1))
        return memo[(i, j)]

    return min(recursive_min_falling_path_sum(0, j) for j in range(n))

# DP
# Time Complexity: O(n^2)
# Space Complexity: O(n^2)

def minFallingPathSum(matrix):
    n = len(matrix)
    dp = [[0] * n for _ in range(n)]
    dp[0] = matrix[0]

    for i in range(1, n):
        for j in range(n):
            if j == 0:
                dp[i][j] = matrix[i][j] + min(dp[i - 1][j], dp[i - 1][j + 1])
            elif j == n - 1:
                dp[i][j] = matrix[i][j] + min(dp[i - 1][j - 1], dp[i - 1][j])
            else:
                dp[i][j] = matrix[i][j] + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i - 1][j + 1])

    return min(dp[-1])
