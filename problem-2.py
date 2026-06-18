# LEETCODE PROBLEM 931. MINIMUM FALLING PATH SUM
# TIME COMPLEXITY: O(N*N) where N denotes the number of cols/rows present
# SPACE COMPLEXITY: O(N) 
# Any problem you faced while coding this: I had some hiccup while writing the 1D array code mainly on how the optimization is looking and 
# while thinking of the logic I was pretty clear on it but it took me some time while getting it converted to code

class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        #Approach 1
        # m=len(matrix)
        # n=len(matrix[0])
        # dp=[[0]*n for _ in range(m)]
        # for i in range(n):
        #     dp[0][i]=matrix[0][i]
        # for i in range(1,m):
        #     for j in range(n):
        #         if j==0:
        #             dp[i][j]=matrix[i][j]+min(dp[i-1][j],dp[i-1][j+1])
        #         elif j==n-1:
        #             dp[i][j]=matrix[i][j]+min(dp[i-1][j],dp[i-1][j-1])
        #         else:
        #             dp[i][j]=matrix[i][j]+min(dp[i-1][j],min(dp[i-1][j+1],dp[i-1][j-1]))
        # return min(dp[m-1])

        #m=len(matrix)

        #Approach 2
        n=len(matrix)
        dp=list(matrix[0])
        for i in range(1,n):
            new_dp=[0]*n
            for j in range(n):
                if j==0:
                    new_dp[j]=matrix[i][j]+min(dp[j],dp[j+1])
                elif j==n-1:
                    new_dp[j]=matrix[i][j]+min(dp[j],dp[j-1])
                else:
                    new_dp[j]=matrix[i][j]+min(dp[j],min(dp[j+1],dp[j-1]))
            dp=new_dp
        return min(dp)

