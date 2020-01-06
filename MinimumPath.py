// Time Complexity :o(mk)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if(A==None or len(A)==0):
            return 0
        rows=len(A)
        cols=len(A[0])
        for i in range(1,rows):
            for j in range(cols):
                if(j==0):
                    A[i][j]+=min(A[i-1][j],A[i-1][j+1])
                elif j==cols-1:
                    A[i][j]+=min(A[i-1][j],A[i-1][j-1])
                else:
                    A[i][j]+=min(A[i-1][j-1],A[i-1][j],A[i-1][j+1])
        return min(A[rows-1])
