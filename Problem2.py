# TIme Complexity: O(N^2)
# Space Complexity: O(N)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
      # if len(matrix) <= 0:
      #   return 0
      # def helper(matrix, row, indices):
      #   if len(matrix) <= 0 or row >= len(matrix):
      #     return 0
  
      #   rows = len(matrix)
      #   cols = len(matrix[0])
      #   best = float('inf')
  
      #   for j in indices:
      #     if j < 0 or j >= cols:
      #       continue
      #     # pick as start
      #     res = matrix[row][j] + helper(matrix, row + 1, [j, j + 1, j - 1])
      #     best = min(res, best)
      #   return best
      
      # starting = [i for i in range(len(matrix[0]))]
      # return helper(matrix, 0, starting)

      # if len(matrix) <= 0:
      #   return 0
      # dp = [[0] * len(matrix[0]) for _ in range(len(matrix))]

      # for j in range(len(matrix[0])):
      #   dp[0][j] = matrix[0][j]

      # for i in range(1, len(matrix)):
      #   for j in range(len(matrix[0])):
      #     if j <= 0:
      #       dp[i][j] = min(
      #         matrix[i][j] + dp[i - 1][j],
      #         matrix[i][j] + dp[i - 1][j + 1],
      #       )
      #     elif j >= len(matrix[0]) - 1:
      #       dp[i][j] = min(
      #         matrix[i][j] + dp[i - 1][j],
      #         matrix[i][j] + dp[i - 1][j - 1]
      #       )
      #     else:
      #       dp[i][j] = min(
      #         matrix[i][j] + dp[i - 1][j],
      #         matrix[i][j] + dp[i - 1][j + 1],
      #         matrix[i][j] + dp[i - 1][j - 1]
      #       )
        
      # return min(dp[-1])

      if len(matrix) <= 0:
        return 0

      dp = [0] * len(matrix[0])
      for j in range(len(matrix[0])):
        dp[j] = matrix[0][j]
      for i in range(1, len(matrix)):
        temp = [0] * len(matrix[0])
        for j in range(len(matrix[0])):
          if j <= 0:
            temp[j] = min(
              matrix[i][j] + dp[j],
              matrix[i][j] + dp[j + 1]     
            )
          elif j >= len(matrix[0]) - 1:
            temp[j] = min(
              matrix[i][j] + dp[j - 1],
              matrix[i][j] + dp[j],
            )
          else:
            temp[j] = min(
              matrix[i][j] + dp[j - 1],
              matrix[i][j] + dp[j],
              matrix[i][j] + dp[j + 1]     
            )
        dp = temp
      return min(dp)


        
