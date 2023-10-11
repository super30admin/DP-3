# // Time Complexity : O(RC)
# // Space Complexity : O(RC)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]):
        @cache
        def helper(r, c):
            if r == rMax:
                return matrix[r][c]

            down = float('inf')
            downLeft = float('inf')
            downRight = float('inf')

            if c > 0:
                downLeft = matrix[r][c] + helper(r+1, c-1)
            if c < cMax:
                downRight = matrix[r][c] + helper(r+1, c+1)

            down = matrix[r][c] + helper(r+1, c)

            return min(down, downLeft, downRight)

        rMax, cMax = len(matrix)-1, len(matrix[0])-1
        minSum = float('inf')

        for c in range(cMax+1):
            minSum = min(minSum, helper(0, c))

        return minSum
