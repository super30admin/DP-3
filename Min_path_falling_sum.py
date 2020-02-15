// Time Complexity : O(mn) - size of the matrix
// Space Complexity : O(1) as we are doing it in the same array.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
In this problem we start with second row and start looking for the top row at three positions and take the minimum of those elements and store in the array.In this manner we start by traversing through the whole matrix.we get the result by taking the minimum of the last row elements.


class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        for i in range(1,len(A)):
            for j in range(len(A[0])):
                if j==0:
                    A[i][j]=A[i][j]+min(A[i-1][j],A[i-1][j+1])
                elif j==len(A[0])-1:
                    A[i][j]=A[i][j]+min(A[i-1][j],A[i-1][j-1])
                else:
                    A[i][j]=A[i][j]+min(A[i-1][j-1],A[i-1][j],A[i-1][j+1])
        mini=float('inf')
        for j in range(len(A[0])):
            if A[len(A)-1][j]<=mini:
                mini=A[len(A)-1][j]
        return mini