# Time Complexity : O(m*n) where m and n are dimensions of input matrix
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No, since the explanation from class was clear.


# Your code here along with comments explaining your approach
# Dynamic Programming approach from class, where we use dp matrix to take solution
# from the sub problems and use to solve bigger problems

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        rows = len(A)
        columns = len(A[0])
        dp = [[0 for x in range(columns)] for y in range(rows)]
        for j in range(columns):
            dp[0][j] = A[0][j]
        
        for i in range(1, rows):
            for j in range(columns):
                left = dp[i-1][j-1] if j>0 else None
                right = dp[i-1][j+1] if j<columns-1 else None
                cost = A[i][j]
                if not left and right:
                    dp[i][j] = min(cost+right, cost+dp[i-1][j])
                elif not right and left:
                    dp[i][j] = min(cost+left, cost+dp[i-1][j])
                elif left and right:
                    dp[i][j] = min(min(cost+left, cost+right), cost+dp[i-1][j])
                
        mini = dp[rows-1][0]
        for j in range(1, columns):
            if mini > dp[rows-1][j]:
                mini = dp[rows-1][j]
        return mini