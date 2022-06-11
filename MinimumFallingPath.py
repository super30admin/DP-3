class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        '''// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach'''
        if len(matrix)==0:
            return 0
        
        if len(matrix) == 1 and len(matrix[0]) ==1:
            return matrix[0][0]
        elif len(matrix) == 1:
            return min(matrix)
        elif len(matrix[0])==1:
            return sum(matrix[0])
        
        n=len(matrix)
        m=len(matrix[0])
        dp=[[None for i in range(n)] for j in range(m)]
        
        for col in range(m):
            dp[0][col]=matrix[0][col]
        
        for row in range(1,n):
            for col in range(m):
                min_sum=99999
                min_sum=min(min_sum, dp[row-1][col] )
                if col-1 >=0:
                    min_sum=min(min_sum, dp[row-1][col-1])
                if col+1<m:
                    min_sum=min(min_sum, dp[row-1][col+1])
                
                dp[row][col]=min_sum+matrix[row][col]
            
        ans=dp[n-1][0]
        for i in range(1,m):
            ans=min(ans, dp[n-1][i])
        return ans
        
        
            
    
                    
                
                
                
        
        
