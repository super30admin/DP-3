# Time Complexity : O(N^2) size of the A grid
# Space Complexity : O(N^2) size of DP array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        """
        Can't use greedy 
        There is a repeated sub problem.
        Have edge cases to worry about if we are on edge of matrix
        """
        if not A:
            return -1
        
        dp = [[0 for j in range(len(A[0]))]  for i in range(len(A)) ]
        
        dp[0] = A[0]
        
        for i in range(1,len(A)):
            for j in range(0,len(A[0])):
                #edge cases if its the ends
                if j == 0:
                    dp[i][j] = A[i][j] + min(dp[i-1][j], dp[i-1][j+1])
                elif j == len(A)-1:
                    dp[i][j] = A[i][j] +  min(dp[i-1][j], dp[i-1][j-1])
                else:
                    dp[i][j] = A[i][j] + min(dp[i-1][j-1], dp[i-1][j+1], dp[i-1][j])
        
        return min(dp[-1])


# Input: [[1,2,3],[4,5,6],[7,8,9]]
# Output: 12
# Explanation: 
# The possible falling paths are:
# [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
# [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
# [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]