"""
https://leetcode.com/problems/minimum-falling-path-sum/

Approach --
- Start with second last row to move upward
- Follow bottom up approach

TC - O(n*n) - since traversal through whole matrix is required
SC - O(n)
"""

m = [[2, 1, 3], [6, 5, 4], [7, 8, 9]]


def minFallingPathSum(matrix):
    n = len(matrix)

    # n-2 since we start from second last row and move upwards following the bottom up approach
    for i in range(n - 2, -1, -1):
        for j in range(0, n):
            if j == 0:
                matrix[i][j] += min(matrix[i + 1][j], matrix[i + 1][j + 1])
            elif j == n - 1:
                matrix[i][j] += min(matrix[i + 1][j], matrix[i + 1][j - 1])
            else:
                matrix[i][j] += min(matrix[i + 1][j], matrix[i + 1][j - 1], matrix[i + 1][j + 1])

    min_val = float('inf')
    for j in range(n):
        min_val = min(min_val, matrix[0][j])
    return min_val


print(minFallingPathSum(m))
