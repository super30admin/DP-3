"""
Approach:
The pattern is same as that of house paint so we'd use the same approach. Instead of having just 3 cols as in case of
house paint, we might have multiple choices, we traverse through all columns of the row and trigger our logic.

"""
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        # Approach 1: Top down
        """
        rows = [0]*len(matrix)
        for i in range(len(matrix)):
            rows[i] = self.helper(matrix, 0, i, 0)

        return min(rows)

    def helper(self, matrix, row, index, sum_):
        #base case
        if row >= len(matrix):
            return sum_

        #case for start index
        case0, case1, case2 = float('inf'),float('inf'),float('inf')
        if index == 0:
            case0 = min( self.helper(matrix, row+1, index, sum_ + matrix[row][index]),\
                        self.helper(matrix, row+1, index+1, sum_ + matrix[row][index]))

        # case for end index
        elif index == len(matrix) - 1:
            case1 = min( self.helper(matrix, row+1, index, sum_ + matrix[row][index]),\
                        self.helper(matrix, row+1, index-1, sum_ + matrix[row][index]))

        # case for indices in middle
        else:
            case2 = min( self.helper(matrix, row+1, index, sum_ + matrix[row][index]),\
                        self.helper(matrix, row+1, index-1, sum_ + matrix[row][index]),\
                        self.helper(matrix, row+1, index+1, sum_ + matrix[row][index]))

        return min(case0, case1, case2)
        """
        # Approach 2: bottom up
        len_cols = len(matrix[0])
        len_rows = len(matrix)
        dp = [[0] * len_cols for _ in range(len_rows)]
        dp[-1] = matrix[-1]

        for i in range(len_rows - 2, -1, -1):
            for j in range(len_cols):
                if j == 0:
                    dp[i][j] = matrix[i][j] + min(dp[i + 1][j], dp[i + 1][j + 1])
                elif j == len_cols - 1:
                    dp[i][j] = matrix[i][j] + min(dp[i + 1][j], dp[i + 1][j - 1])
                else:
                    dp[i][j] = matrix[i][j] + min(dp[i + 1][j], dp[i + 1][j - 1], dp[i + 1][j + 1])
        return min(dp[0])

"""
Approach 1:
TC: O(m * 2^n) where n = rows in matrix
SC: O(nm)
Approach 2:
TC: O(nm)
SC: O(nm)
"""