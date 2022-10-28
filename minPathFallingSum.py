#Time Complexity: O(row*col)
#Space Complexity: O(row*col)
#Did it run on leetcode: Yes

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        rows = len(matrix)
        columns = len(matrix[0])
        dp = [[0]*columns for index in range(rows)]
        for jindex in range(columns):
            dp[0][jindex] = matrix[0][jindex]
        for index in range(1, rows):
            for jindex in range(columns):
                if jindex == 0:
                    dp[index][jindex] = min(dp[index - 1][jindex] + matrix[index][jindex],
                                            dp[index - 1][jindex + 1] + matrix[index][jindex])
                elif jindex == columns - 1:
                    dp[index][jindex] = min(dp[index - 1][jindex] + matrix[index][jindex],
                                           dp[index - 1][jindex - 1] + matrix[index][jindex])
                else:
                    dp[index][jindex] = min(dp[index - 1][jindex - 1] + matrix[index][jindex],
                                           dp[index - 1][jindex] + matrix[index][jindex],
                                           dp[index - 1][jindex + 1] + matrix[index][jindex])
        return min(dp[-1])