class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:

        #Here we use DP approach. for each entry of matrix we choose the current entry plus min of previous row enteries which are applicable to it.
        #Time complexity: O(rows.cols)
        #Space complexity: O(rows.cols)
        rows = len(matrix)
        cols = len(matrix[0])

        dp = [[0]*cols for i in range(rows)]

        for i in range(cols):
            dp[0][i] = matrix[0][i]

        for i in range(1, rows):
            for j in range(cols):
                temp1 = dp[i-1][j+1] if (j+1)<cols else math.inf
                temp2 = dp[i-1][j-1] if (j-1)>=0 else math.inf
                minVal = min(dp[i-1][j], temp1, temp2)
                dp[i][j] = minVal + matrix[i][j]

        return min(dp[rows-1][::])