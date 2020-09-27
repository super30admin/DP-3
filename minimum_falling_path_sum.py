#Time Complexity: O(n*n) 
#Space Complexity: O(n*n) for the dp array with copied values from A

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        dp = [row[:] for row in A]

        for i in range(1,len(A)):
            for j in range(len(A[0])):
                if(j==0):
                    dp[i][j] = A[i][j] + min(dp[i-1][j], dp[i-1][j+1])
                elif(j==len(A[0])-1):
                    dp[i][j] = A[i][j] + min(dp[i-1][j-1], dp[i-1][j])
                else:
                    dp[i][j] = A[i][j] + min(min(dp[i-1][j-1], dp[i-1][j]), dp[i-1][j+1])    
        
        return min(dp[-1])