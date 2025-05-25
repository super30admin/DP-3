# // Time Complexity :o(m*n) m - rows n -columns
# // Space Complexity :  o(m*n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : 
# This problem is similar to paint houses problem was able to apply intuition for minPathSum for list 


# // Your code here along with comments explaining your approach
# idea is to go top down by filling the dp value with min from every row and then deciding which is the best one 
# we create a dp array and initialize the first row same as the matrix first row
# exlore all the paths and sums based on the conditions and find the minVal in the end just like paint house

from typing import List
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m ,n = len(matrix) ,len(matrix[0])
        dp = [[0 for j in range(n) ] for i in range(m)]
        for j in range(n):
            dp[m-1][j] = matrix[m-1][j]
        for i in range(m-2,-1,-1):
            for j in range(n):
                if j == 0 :
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j+1], dp[i+1][j])
                elif j == n-1:
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j], dp[i+1][j-1])
                else:
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j+1], dp[i+1][j], dp[i+1][j-1])
        minVal = float('inf')
        for j in range(n):
            minVal = min(minVal, dp[0][j])
        return minVal

        