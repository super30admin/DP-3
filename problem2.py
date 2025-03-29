# Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)

# TC : O(n²)
# - We process each cell in the n×n matrix exactly once
# - Each cell calculation takes O(1) time

# SC : O(n²)
# - We use a dp array of size n×n to store intermediate results

# Approach:
    # 1. Use dynamic programming to find the minimum falling path sum
    # 2. Create a dp array where dp[i][j] represents the minimum sum of any falling path ending at position (i,j)
    # 3. For each cell, calculate the minimum falling path by considering the valid previous positions
    # 4. The minimum value in the last row of dp will be our answer

# On leetcode the code runs : YES

def minFallingPathSum(self, matrix):
    # Get the dimension of the square matrix
    n = len(matrix)
    
    # Initialize dp array with same dimensions as matrix
    # dp[i][j] will store minimum falling path sum ending at position (i,j)
    dp = [[0 for _ in range(n)] for _ in range(n)]
    
    # Initialize first row of dp with first row values of matrix
    # Base case: falling path starts from any element in first row
    for i in range(n):
        dp[0][i] = matrix[0][i]
    
    # Fill the dp array row by row
    for i in range(1, n):  # Start from second row (index 1)
        for j in range(n):  # Process each column
            if j == 0:  # Leftmost column case
                # Can only come from directly above or above-right
                dp[i][j] = matrix[i][j] + min(dp[i-1][j], dp[i-1][j+1])
            elif j == n - 1:  # Rightmost column case
                # Can only come from directly above or above-left
                dp[i][j] = matrix[i][j] + min(dp[i-1][j], dp[i-1][j-1])
            else:  # Middle columns
                # Can come from above-left, directly above, or above-right
                dp[i][j] = matrix[i][j] + min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1])
    
    # Return the minimum value in the last row
    # This represents the minimum sum of any falling path through the matrix
    return min(dp[n-1])