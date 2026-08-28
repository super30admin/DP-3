#Time Complexity : O(r*c)
#Space Complexity : O(c)
#Did this code successfully run on Leetcode :Yes
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        dp=matrix[-1][:]
        rows = len(matrix)
        cols = len(matrix[0])
        for i in range(rows-2,-1,-1):
            new_dp = [0]*cols
            for j in range(cols):
                down = dp[j]
                down_left = dp[j-1] if j > 0 else float('inf')
                down_right = dp[j+1] if j < cols-1  else float('inf')
                new_dp[j] = matrix[i][j]+ min(down,down_left,down_right)
            dp = new_dp
        return min(dp)
        
