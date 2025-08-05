#Time Complexity : O(m*n)
#Space Complexity : O(n)
#Any problem you faced while coding this : none

#Your code here along with comments explaining your approach
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """

        m=len(matrix)
        n=len(matrix[0])
        dp=[[0 for _ in range(0,n)]for _ in range(0,m)]

        for j in range(0,n):
            dp[m-1][j]=matrix[m-1][j]  # fill the last row
        
        for i in range(m-2,-1,-1):
            for j in range(0,n):
                min_val=float('inf')
                if j==0:                # if the first column then min between the element below it and diagonal to the right 
                    min_val=min(min_val,dp[i+1][j],dp[i+1][j+1])
                elif j==n-1:            # if the last column then min between the element below it and diagonal to the left
                    min_val=min(min_val,dp[i+1][j],dp[i+1][j-1])
                else:                   # if any other element then find the min of all the three 
                    min_val=min(min_val,dp[i+1][j],dp[i+1][j-1],dp[i+1][j+1])
                dp[i][j]=matrix[i][j]+min_val
        
        
        return min(dp[0]) # return the top element 