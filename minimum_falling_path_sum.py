# Time Complexity :
# O(MN)

# Space Complexity :
# O(MN)

# Did this code successfully run on Leetcode :
#Yes

#We traverse this matrix bottom up - and store the best cost to reach the bottom from the current given location. That best cost is it's own position's cost + minimum of its potential next steps
#We do this at all elements and return the minimum from the first row (as we need to start from first row)

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        m = len(matrix[0])
        dp = [[0]*m for i in range(n)]

        for j in range(0,m):
            dp[n-1][j] = matrix[n-1][j]

        for i in reversed(range(0,n-1)):
            for j in range(0,m):
                path_vales = [dp[i+1][j]]

                if j != 0 :
                    path_vales.append(dp[i+1][j-1])

                if j != m-1 :
                    path_vales.append(dp[i+1][j+1])
                dp[i][j] = matrix[i][j] + min(path_vales)

        return min(dp[0])
