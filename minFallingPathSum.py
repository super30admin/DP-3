"""
Time Complexity : O(mn)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        m = len(A)
        n = len(A[0])
        for i in range(1, m):
            for j in range(n):
                if j == 0:
                    A[i][j] += min(A[i-1][j], A[i-1][j+1])
                elif j == (n-1):
                    A[i][j] += min(A[i-1][j-1], A[i-1][j])
                else:
                    A[i][j] += min(A[i-1][j-1], A[i-1][j], A[i-1][j+1])
                    
        return(min(A[-1]))