class Solution:
    '''
    T = O(N^2)
    S = O(N^2)
    '''
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        if rows == 1:
            return matrix[0][0]
        dp = [ [ None for x in range(cols)] for x in range(rows)]
        for col in range(cols):
            dp[0][col] = matrix[0][col]
        for row in range(1, rows):
            for col in range(cols):
                if col == 0:
                    dp[row][col] = matrix[row][col] + min( dp[row-1][col] , dp[row-1][col+1]  )
                elif col == cols - 1:
                    dp[row][col] = matrix[row][col] + min( dp[row-1][col] , dp[row-1][col-1] )
                else:
                    dp[row][col] = matrix[row][col] + min( dp[row-1][col] , dp[row-1][col-1], dp[row-1][col+1]  )
        ans = float("inf")
        for col in range(cols):
            ans = min( ans , dp[row][col]  )
        return ans
      
    
