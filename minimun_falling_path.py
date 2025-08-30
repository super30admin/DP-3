def minFallingPathSum(self, matrix: List[List[int]]) -> int: #Tc:O(m*n) SC: O(m*n)
        m=len(matrix)
        n=len(matrix[0])

        dp=[[0]*n for _ in range(m)]
        for j in range(n):
            dp[0][j]=matrix[0][j]

        for i in range(1,m):
            for j in range(n):
                min_next=dp[i-1][j]
                if j>0:
                    min_next=min(min_next,dp[i-1][j-1])
                if j<n-1:
                    min_next=min(min_next,dp[i-1][j+1])
                dp[i][j]=matrix[i][j]+min_next

        return min(dp[m-1])
        