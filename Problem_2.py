# Runs on Leetcode
    # Runtime - O(m*n)
    # Space - O(n) where m is # of rows and n is # of cols

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if not A:
            return 0
        
        rows = len(A)
        cols = len(A[0])
        
        dp = A[0]
        
        for i in range(1,rows):
            pre = dp[:]
            for j in range(cols):
                if j == 0:
                    dp[j] = A[i][j] + min(pre[j], pre[j+1])
                elif j == cols-1:
                    dp[j] = A[i][j] + min(pre[j-1], pre[j])
                else:
                    dp[j] = A[i][j] + min(min(pre[j-1],pre[j]), pre[j+1])
        return min(dp)
