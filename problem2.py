'''
Dp Solution
Time Complexity :O(n^2)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation:
In the same 2D matrix find the minimum of the upper row elements for each condition. Take care of some boundary conditions as well.
'''

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if A == None or len(A) == 0:
            return 0

        n = len(A)

        for i in range(1, n):
            for j in range(0, n):
                # consider 2 upper cases
                # consider 2 upper elements
                if j == 0:
                    A[i][j] = A[i][j] + min(A[i - 1][j], A[i - 1][j + 1])
                elif j == n - 1:
                    A[i][j] = A[i][j] + min(A[i - 1][j], A[i - 1][j - 1])
                else:
                    A[i][j] = A[i][j] + min(A[i - 1][j], A[i - 1][j + 1], A[i - 1][j - 1])

        min1 = 99999

        for i in range(0, n):
            min1 = min(min1, A[n - 1][i])
        return min1