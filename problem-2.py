"""
Approach

1. To find the the minimum falling path sum we can construc the dp matrix as follows
2. each cell calucated by adding the cost for that cell with the minimum of the cells from the rows above the current row
3. the minimum falling path sum will be the minimum value from the dp matrix

"""


# Time Complexity : O(n*T) where n is the number of coins and T is the target
# Space Complexity : O(n*T) where n is the number of coins and T is the target
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        n = len(A)
        dp =  [ [0 for j in range (n)] for i in range(n) ]
        #dp = A[0][:]
        
        # Initilize first row of DP matrix with given array
        for i in range (n):
            dp[0][i] = A[0][i]
        
        # Start calculating from the second row onwards
        for i in range (1,n):
            for j in range (n):
                if j==0:
                    dp[i][j] = A[i][j] + min(dp[i-1][j],dp[i-1][j+1])
                    
                elif j==n-1:
                    dp[i][j] = A[i][j] + min(dp[i-1][j],dp[i-1][j-1])
                    
                else:
                    dp[i][j] = A[i][j] + min(dp[i-1][j],dp[i-1][j-1],dp[i-1][j+1])
                    
        return min (dp[n-1])
        