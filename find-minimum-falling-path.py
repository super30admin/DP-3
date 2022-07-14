"""
Runtime Complexity:
O(n^2) - we run two for loops to iterate through 'm' rows and 'n' columns to compute our dp matrix.
Space Complexity:
O(n^2) - because we create a 2D dp array to compute the solution.
Yes, the code worked on leetcode.
 
"""

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        result =[]
        m = len(matrix)
        n = len(matrix[0])
        dp = [[i for i in range(m)]for j in range(n)]
        
        for j in range(n):
                dp[0][j] = matrix[0][j]
        
        
        for i in range(1,m):
            for j in range(0,n):
        
         
                if j ==0:       #if the index is at 0, we check the element directly above and next to it.
                    dp[i][j] = matrix[i][j] + min(dp[i-1][j], dp[i-1][j+1])
                elif j==n-1:    #if the index is at last column, we check element directly above and its left.
                    dp[i][j] = matrix[i][j]+ min(dp[i-1][j-1],dp[i-1][j])
                else:           #if the index is at middle column, we have to check element directly above and to its left as well as right.
                    dp[i][j] = matrix[i][j] + min(dp[i-1][j-1], dp [i-1][j], dp[i-1][j+1])
        return min([dp[m-1][j] for j in range(n-1,-1,-1)])  # return the min element in the last row, because thi contains the sum from the top.
            
        
        
                
        