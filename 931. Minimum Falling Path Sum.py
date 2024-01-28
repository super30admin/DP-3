# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n^2)
# Space Complexity : Average : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    '''
    - Repetetive subproblems were detected during exhaustive approach, so dp being used
    - during iteration to a specific value, all connected values in next row(c, c+1, c-1)
    - are compared and minimum sum is stored in memory.
    '''
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        if n > 1:
            for r in range(n -1)[::-1]:
                for c in range(n):
                    if c == 0:
                        matrix[r][c] = matrix[r][c] + min(matrix[r+1][c], matrix[r+1][c+1])
                    elif c == n - 1:
                        matrix[r][c] = matrix[r][c] + min(matrix[r+1][c], matrix[r+1][c-1])
                    else:
                        matrix[r][c] = matrix[r][c] + min(matrix[r+1][c], matrix[r+1][c+1], matrix[r+1][c-1])
        minimum = matrix[0][0]
        for c in range(n):
            minimum = min(minimum, matrix[0][c])
        return minimum