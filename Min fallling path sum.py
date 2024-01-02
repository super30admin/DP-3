class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix) == 1:
            return min(matrix[0])
            
        dp = [0] * len(matrix[0])

        for row in matrix:
            temp = dp.copy()
            for i in range(len(row)):
                if i == 0:
                    dp[i] = min(temp[i] + row[i], dp[i + 1] + row[i])
                elif i == len(row) - 1:
                    dp[i] = min(temp[i] + row[i], temp[i - 1] + row[i])
                else:
                    dp[i] = min(temp[i] + row[i], temp[i - 1] + row[i], temp[i + 1] + row[i])
        
        return min(dp)

# Time complexity : O(N ^ 2)
# Space complexity : O(N)
