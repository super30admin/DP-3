## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)

# Time Complexity : O(n^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def minFallingPathSum(self, A):
        if not A:
            return 0
        n = len(A)
        for i in range(1, n):
            for j in range(n):
                if j == 0:
                    A[i][j] += min(A[i - 1][j], A[i - 1][j + 1])
                elif j == n - 1:
                    A[i][j] += min(A[i - 1][j], A[i - 1][j - 1])
                else:
                    A[i][j] += min(A[i - 1][j], A[i - 1][j + 1], A[i - 1][j - 1])
        return min(A[-1])

