'''
Time Complexity: O(N*M)
Space Complexity: O(N*M)
'''
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        dp = matrix.copy()
        rows = len(dp)
        cols = len(dp[0])
        minval = float("inf")
        for i in range(rows-1, -1, -1):
            for j in range(0, cols):
                if(i < len(dp)-1):
                    val1 = val2 = val3 = float("inf")
                    # Case 1:[row+1][col]
                    if(i+1<rows):
                        val1 = dp[i+1][j]
                        if(j-1>=0):
                            val2 = dp[i+1][j-1]
                        if(j+1<cols):
                            val3 = dp[i+1][j+1]
                    matrix[i][j] += min(val1, val2, val3)
                if(i==0):
                    val = matrix[i][j]
                    if(val<minval):
                        minval = val
        return minval
        
                    
        