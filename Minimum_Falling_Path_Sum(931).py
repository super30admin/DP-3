# Time Complexity : O(m*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)

        if n == 0 or matrix == None:
            return 0

        # Here we use a Bottom-up DP approach
        # starting from the 2nd last row: we iterate over the columns
        # (since we can only use the 3 columns just below the current one)
        # and add the minimum amount of the 3 columns
        # finally we will have the total minimum costs for each of the min paths in the 0th row
        # and we return whichever is the minimum out of the 3
        for row in reversed(range(n-1)):
            for col in range(n):
                if col == 0:
                    matrix[row][col] += min(matrix[row+1][col], matrix[row+1][col+1])
                elif col == n-1:
                    matrix[row][col] += min(matrix[row+1][col-1],matrix[row+1][col])
                else:
                    matrix[row][col] += min(matrix[row+1][col], min(matrix[row+1][col-1],matrix[row+1][col+1]))

        min_sum = sys.maxsize
        for i in matrix[0]:
            min_sum = min(i,min_sum)

        return min_sum