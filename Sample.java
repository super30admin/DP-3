# Delete and Earn:
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        counter = Counter(nums)
        max_n = max(nums)
        dp = [0] * (max_n + 1)
        dp[1] = counter[1]
        for i in range(2, max_n + 1):
            dp[i] = max(dp[i-1], dp[i-2] + counter[i] * i)
        return dp[-1]

# Minimum falling path sum
Time : 0(m*n)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m = len( matrix)
        n = len( matrix[0])
        
        for i in range (1,m):
            for j in range (n):
                if j == 0:
                    matrix[i][j] += min( matrix[i-1][j], matrix[i-1][j+1])
                elif j == n-1:
                    matrix[i][j] += min( matrix[i-1][j], matrix[i-1][j-1])
                else:
                    matrix[i][j] += min( min( matrix[i-1][j], matrix[i-1][j+1]), matrix[i-1][j-1])
        
        return min( matrix[m-1])