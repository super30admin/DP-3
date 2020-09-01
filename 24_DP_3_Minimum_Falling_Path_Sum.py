#Time Complexity : O(n*m) where n=no of rows, m=no of cols  
#Space Complexity : O(n*m) where n=no of rows, m=no of cols  
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :

#Your code here along with comments explaining your approach

class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        
        if len(A)==0: 
            return 0
        
        row=len(A)
        col=len(A[0])
        
        dp=[[0]*col for i in range(row)]
        
        for i in range(col):
            dp[0][i]=A[0][i]
            
        for i in range(1,row): 
            for j in range(col): 
                if j==0: 
                    dp[i][j]=A[i][j]+min(dp[i-1][j],dp[i-1][j+1])
                elif j==col-1: 
                    dp[i][j]=A[i][j]+min(dp[i-1][j],dp[i-1][j-1])
                else: 
                    dp[i][j]=A[i][j]+min(min(dp[i-1][j],dp[i-1][j-1]),dp[i-1][j+1])
        
        return min(dp[row-1])