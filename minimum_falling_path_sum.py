'''
// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : similar intution like paint house problem


// Your code here along with comments explaining your approach
Approach: DP
1.  The DP formula to compare 3 choices from above and get the minimum sum
'''
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        # TC: O(m * n), SC: O(m * n)
        if matrix == None or len(matrix) == 0: return 0
        
        row, col = len(matrix), len(matrix[0]) + 2
        dp = [[float('inf')] * col for _ in range(row)]
        
        for j in range(1, col - 1):
            dp[0][j] = matrix[0][j - 1]
        
        for i in range(1, row):
            for j in range(1, col - 1):
                from_topleft    = matrix[i][j-1] + dp[i-1][j-1]
                from_top        = matrix[i][j-1] + dp[i-1][j]
                from_topright   = matrix[i][j-1] + dp[i-1][j+1]
                dp[i][j] = min(from_topleft, from_top, from_topright)
            
        return min(dp[-1])