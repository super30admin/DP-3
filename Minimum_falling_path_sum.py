# TC: O(n2)
# SC: O(n)

import math
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if matrix == None:
            return 0
        n = len(matrix)
        res = [0] * (n+1)

        for i in range(n-1, -1, -1):
            temp = [0] * (n+1)
            for j in range(0, n):
                if j == 0:
                    temp[j] = matrix[i][j] + min(res[j], res[j+1])
                elif j == len(matrix[i]) - 1:
                    temp[j] = matrix[i][j] + min(res[j], res[j-1])
                else:
                    temp[j] = matrix[i][j] + min(res[j+1], res[j], res[j-1])
            res = temp

        minSum = math.inf
        for k in range(0, len(matrix)):
            minSum = min(minSum, res[k])

        return minSum