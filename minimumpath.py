class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        #initializing DP matrix
        dp=[[0 for i in range(len(A))]for j in range(len(A))]
        #checking condition for null value
        if A==None or len(A)==0:
            return 0
        #initializing first row of DP matrix
        dp[0]=A[0]
        for i in range(1,len(A)):
            for j in range(len(A)):
                #updating the first column of DP matrix
                if j==0:
                    dp[i][j]=A[i][0]+min(dp[i-1][0],dp[i-1][1])
                #updating the last column of DP matrix
                elif j==len(A)-1:
                    dp[i][j]=A[i][len(A)-1]+min(dp[i-1][len(A)-1],dp[i-1][len(A)-2])
                #updating the remaining colums of DP matrix
                else:
                    dp[i][j]=A[i][j]+min(dp[i-1][j-1],dp[i-1][j+1],dp[i-1][j])
        return min(dp[len(A)-1])