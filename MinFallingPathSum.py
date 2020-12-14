# DP solution
# TC : O (m*n) ; row * column
# SC : O(1)
# Approach : We start from 2nd row, and store min. sum of current and previous row's elements 
# (according to specified rules) and we repeat until we reach at last row. We return min value from last row, 
# indicating min falling path sum.
class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if not A or len(A) == 0:
            return 0
        
        for i in range(1, len(A)):
            for j in range(len(A[0])):
                if j == 0:
                    A[i][j] += min(A[i - 1][j], A[i - 1][j + 1])
                elif j == len(A[0]) - 1:
                    A[i][j] += min(A[i - 1][j], A[i - 1][j - 1])
                else:
                    A[i][j] += min(A[i - 1][j], min(A[i - 1][j - 1], A[i - 1][j + 1]))

        return min(A[len(A) - 1])