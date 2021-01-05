class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        '''
        Complexity:
            Time: O(n^2)
            Space: O(n)
        '''
        dp = A[-1].copy()
        x = dp.copy()
        for i in range(len(A)-2,-1,-1):
            for j in range(0,len(dp)):
                if(j==0):
                    x[j] = A[i][j] + min(dp[j],dp[j+1]) 
                elif(j==len(dp)-1):
                    x[j] = A[i][j] + min(dp[j],dp[j-1])
                else:
                    x[j] = A[i][j] + min(dp[j],dp[j-1],dp[j+1])
            
            dp = x.copy()
        
        return min(dp)
