# Time Complexity : O(N^(2))
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        dp = matrix[0][:] # Each optimal choice depends on the previous level. Hence, 1D array is enough.
        temp = [0] * len(matrix[0]) # We need a temp array to avoid read after write incoherence.
        
        for i in range(1, len(matrix)):
            for j in range(len(matrix[0])):
                left = float("inf") if j - 1 < 0 else dp[j-1] # I prepare left if valid otherwise set to infinity
                right = float("inf") if j + 1 >= len(matrix[0]) else dp[j+1] # I prepare right if valid otherwise set to infinity
                top = dp[j] # Top is always valid
                temp[j] = min(left, right, top) + matrix[i][j] # Take the minimum option and add current cost
            
            dp = temp[:] # Copy the temp over as current dp array.
        
        return min(dp) # The minimum is the best choice.
                
                