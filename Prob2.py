# // Time Complexity : O(m*n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        # m=len(matrix)
        # n=len(matrix[0])

        # dp=[[0 for _ in range(n)] for _ in range(m)]
        # dp[m-1]=matrix[m-1] #copy the last row

        # for i in reversed(range(m-1)):
        #     for j in range(n):
        #         dp[i][j]=matrix[i][j]+min(
        #             dp[i+1][j],
        #             dp[i+1][j-1] if j>0 else float('inf'),
        #             dp[i+1][j+1] if j<n-1 else  float('inf'))
        
        # return min(dp[0])
        m=len(matrix)
        n=len(matrix[0])
        dp=matrix[m-1][:] #copy the last row

        for i in reversed(range(m-1)):
            new_dp=[0 for _ in range(n)]
            for j in range(n):
                new_dp[j]=matrix[i][j]+min(
                    dp[j],
                    dp[j-1] if j>0 else float('inf'),
                    dp[j+1] if j<n-1 else  float('inf'))
            dp=new_dp
        
        return min(dp)
