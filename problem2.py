"""
Space Complexity: O(R * C)

Time Complexity: O(R * C)

"""
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        R,C = len(matrix), len(matrix[0])
        INF = 10 ** 20 
        dp = [[0 for _ in range(C)] for _ in range(R)]

        for j in range(C): 
            dp[R-1][j] = matrix[R-1][j]

        for i in range(R-2, -1, -1): 
            for j in range(C): 
                if j-1 < 0: 
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j], dp[i+1][j+1])
                    
                elif j+1 >= C: 
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j], dp[i+1][j-1])
                else: 
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j], dp[i+1][j-1], dp[i+1][j+1])

        ans = INF

        for j in range(C): 
            ans = min(ans, dp[0][j])
        return ans


