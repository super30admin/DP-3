# Time Complexity : O(n^2), where n is the number of rows or columns in the matrix
# Space Complexity : O(1), done in-place without extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

def minFallingPathSum(matrix):
    n = len(matrix)

    # Starting from the second last row and moving upwards
    for i in range(n - 2, -1, -1):
        for j in range(n):
            # Calculate minimum from the three possible paths below
            left = matrix[i + 1][j - 1] if j > 0 else float('inf')
            down = matrix[i + 1][j]
            right = matrix[i + 1][j + 1] if j < n - 1 else float('inf')
            matrix[i][j] += min(left, down, right)

    # Return the minimum value from the top row
    return min(matrix[0])
