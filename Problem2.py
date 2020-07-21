#Problem 2 : https://leetcode.com/problems/minimum-falling-path-sum/
#Test Cases Passed on LeetCode
#Time Complexity-O(N*N)
#Space Complexity-O(N*N)
class Solution:
    def minFallingPathSum(self, A):
        n=len(A)
        dp=[[0 for j in range(n)]for i in range(n)]
        for i in range(n):
            dp[0][i]=A[0][i]
        for i in range(1,n):
            for j in range(n):
                if j==0:
                    dp[i][j]=A[i][j]+min(dp[i-1][j],dp[i-1][j+1])
                elif j==n-1:
                    dp[i][j]=A[i][j]+min(dp[i-1][j],dp[i-1][j-1])
                else:
                    dp[i][j]=A[i][j]+min(dp[i-1][j],dp[i-1][j+1],dp[i-1][j-1])
        minimum=float("inf")
        for i in range(n):
            if minimum>dp[n-1][i]:
                minimum=dp[n-1][i]
        return minimum
sol=Solution()
A =[[1,2,3],[4,5,6],[7,8,9]]
print(sol.minFallingPathSum(A))













