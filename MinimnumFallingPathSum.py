# Time Complexity : O(nm) where n : rows and m : columns
# Space Complexity : O(m) where m : columns
 
from typing import List

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        m = len(matrix[0])
        
        # Initialize dp array with the first row of the matrix
        dp = matrix[0]
        
        # Iterate over the rows of the matrix and update dp array
        for i in range(1, n):
            # Create a temporary array to store the updated values of dp array
            temp = [0] * m
            
            # Update the first element of the temporary array
            temp[0] = matrix[i][0] + min(dp[0], dp[1])
            
            # Update the last element of the temporary array
            temp[m-1] = matrix[i][m-1] + min(dp[m-2], dp[m-1])
            
            # Update the rest of the elements of the temporary array
            for j in range(1, m-1):
                temp[j] = matrix[i][j] + min(dp[j-1], dp[j], dp[j+1])
            
            # Update the dp array with the temporary array
            dp = temp
        
        # Return the minimum value of the dp array
        return min(dp)