# Brute Force: Start from top row and recursively try out all combinations on the values in row
# Base case: Repeat recursion until we reach out of bounds of the matrix
# Exponential Time complexity
# Time : O(m * n) where we traverse across a 2d array
# Space: O(m * n) where we store an aux array

# Approach:
# At any time we are allowed to choose col values at most 1 (ie 0 or 1)
# when j is 0 -->
    # we can choose the same column or col + 1

# when j is the last col
    # we can choose the same col or col -1 val

# when in middle we can consider same col, col-1 & col + 1
# atlast we return the min value recorded in the dp array

def min_falling_path(nums):

    rows = len(nums)
    cols = len(nums[0])

    dp = [[0] * cols for i in range(rows)]

    for j in range(cols):
        dp[0][j] = nums[0][j]

    for i in range(1, rows):
        for j in range(cols):
            if j == 0:
                dp[i][j] = nums[i][j] + min(dp[i-1][j], dp[i-1][j+1])

            elif j == cols - 1:
                dp[i][j] = nums[i][j] + min(dp[i-1][j], dp[i-1][j-1])

            else:
               
                dp[i][j] = nums[i][j] + min(dp[i-1][j], dp[i-1][j-1], dp[i-1][j+1])


    return min(dp[rows-1])