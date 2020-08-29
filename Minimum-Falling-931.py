# Time Complexity : O(nm)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        if len(A) == 0:
            return 0
        
        for i in range(1, len(A)):
            for j in range(0, len(A[0])):
                if j == 0:
                    A[i][j] += min(A[i-1][j],A[i-1][j+1])
                elif j == len(A) - 1:
                    A[i][j] += min(A[i-1][j], A[i-1][j-1])
                else:
                    A[i][j] += min(A[i-1][j], A[i-1][j-1], A[i-1][j+1])
        return min(A[len(A[0]) - 1])
