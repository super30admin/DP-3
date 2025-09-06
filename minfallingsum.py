# Time Complexity : O(N*N)
# Space Complexity : O(N*N)  
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, checked the provided solution for better understanding. 


# Your code here along with comments explaining your approach:
# I am using a 2D dp array to store the minimum falling path sum up to each element in the matrix.
# I initialize the first row of the dp array with the first row of the input matrix.
# Then, I iterate through the matrix starting from the second row, and for each element,
# I calculate the minimum falling path sum by considering the three possible elements from the previous row (directly above, above-left, and above-right).
# Finally, I return the minimum value from the last row of the dp array, which represents the minimum falling path sum for the entire matrix.

from typing import List
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        dp = [[0] * n for _ in range(n)]
        for i in range(n):
            dp[0][i] = matrix[0][i]

        for i in range(1, n):
            for j in range(n):
                if j == 0:
                    dp[i][j] = matrix[i][j] + min(dp[i-1][j], dp[i-1][j+1])
                elif j == n - 1:
                    dp[i][j] = matrix[i][j] + min(dp[i-1][j-1], dp[i-1][j])
                else:
                    dp[i][j] = matrix[i][j] + min(min(dp[i-1][j-1], dp[i-1][j]), dp[i-1][j+1])

        return min(dp[n-1][i] for i in range(n))
        
        