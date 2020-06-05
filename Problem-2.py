# Time Complexity :O(M*N)
# Space Complexity :O(M*n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        if not A or len(A) ==0:
            return 0
        for i in range(1,len(A)):
            for j in range(len(A[0])):
                if j == 0:
                    #chose the min you can chose from the one max away from your col by one
                    A[i][j] += min(A[i-1][j],A[i-1][j+1])
                elif j == (len(A)-1):
                    A[i][j] += min(A[i-1][j],A[i-1][j-1])
                else:
                    A[i][j] += min(A[i-1][j],A[i-1][j-1],A[i-1][j+1])
            #return the min calculated
        return min(A[-1])