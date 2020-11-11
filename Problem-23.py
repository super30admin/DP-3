#minimum falling path -931
#Time complexity =O(N^2)
#space complexity =O(N^2)
#passed all test cases 
#Approach- DP first row remains the same. Subsequent rows takes the minimum value from above rows and add the value in current row column value. for 1 and last columns it's different and middle columns it's different.



class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        r=len(A)
        dp=[[0]*r for _ in range(r)]
        n=len(dp)
        
        # first row remains the same 
        for i in range(n): 
            dp[0][i]=A[0][i]
            
        for i in range(1,n):
            for j in range(0,n):
                
                #first column
                if (j==0):
                    dp[i][j]=min(dp[i-1][j],dp[i-1][j+1])+A[i][j]
                
                #last column
                elif (j==n-1):
                    dp[i][j]=min(dp[i-1][j],dp[i-1][j-1])+A[i][j]
                
                #middle cloumns from 1 to n-1
                else:
                    dp[i][j]=min(dp[i-1][j-1],min(dp[i-1][j],dp[i-1][j+1]))+A[i][j]
                
        min_val = float("inf")
        for i in range(n):
            min_val=min(min_val,dp[n-1][i])
        return min_val
        