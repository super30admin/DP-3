Time complexity: O(nlogn)
Space complexity: O(n)
Challenges: Error - index out of range 
Executed in Leetcode: No, working on it. Getting index out of range error.
Comments: Given below

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:       
        # Find rows and column count and account for a single row and column
        rows,cols = len(A), len(A[0])                        
        if rows is 1: return min(A[0])
        if cols is 1: return sum(A)    
        
        # Create a dp array with infinity as values
        dp = [[float('inf') for x in range(cols)] for y in range(rows)]
        
        # Fill values
        for j in range(cols): dp[rows-1][j] = A[rows-1][j]
        # fill values from last to first row - getting error - out of index here
        for i in range(rows,0,-1):
            for j in range(cols):
                # Find next row values on same column, column -1 and column + 1
                x = dp[i][j-1] if j > 0 else float('inf')
                y = dp[i][j]
                z = dp[i][j+1] if j+1 < cols else float('inf')
                # Value  at the point and minimum of values in next row in same column or column -1 or colun + 1
                dp[i-1][j] = A[i-1][j] + min(x,y,z)  
        # Return the minimum value
        return min(dp[0])

        
