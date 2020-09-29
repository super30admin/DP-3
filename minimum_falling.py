class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        for i in reversed(range(0,len(A)-1)):
            for j in range(0,len(A)):
                if j==0:
                    A[i][j] = A[i][j]+min(A[i+1][j],A[i+1][j+1])
                elif j==len(A)-1:
                    A[i][j] = A[i][j]+min(A[i+1][j-1],A[i+1][j])
                else:
                    print(min(A[i+1][j-1],A[i+1][j+1],A[i+1][j]))
                    A[i][j] = A[i][j]+min(A[i+1][j-1],A[i+1][j+1],A[i+1][j])
        print(A)
        return min(A[0])
