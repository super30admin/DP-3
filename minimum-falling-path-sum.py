# Reference Video: https://youtu.be/Xr_LRdr9IPQ
# Bottom up approach
# Time Complexity: O(mn)
# Space Complexity: O(mn)
#fill the last column first
# assign original elements to each column
# Assign min to be always the element below it
# For a 3X3 matrix, add the element with the min of the last row (by checking if the left element and right element exist)
#return the min of top row
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        dp = [[0 for _ in range(cols)]for _ in range(rows)]
        
        #assigning the last row as it is to dp
        dp[cols-1] = matrix[cols-1]
        
        for i in range(rows - 2,-1,-1):
            for j in range(cols):
                
                dp[i][j] = matrix[i][j]
                result = dp[i+1][j]
                
                # right column exists, finding the min in the next row
                if j+1 < cols:
                    result = min(result, dp[i+1][j+1])
                
                # left column exists, finding the min in the next row
                if j-1 >= 0:
                    result = min(result, dp[i+1][j-1])
                    
                dp[i][j] += result
                
       
        output = float('inf')
        for i in range(cols):
            output = min(output, dp[0][i])
        return output
                    
                    
            
        
        