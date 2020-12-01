class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        #traversing 2D array and starting from 1st row because we need to start summing up for row2
        for i in range(1,len(A)):
            for j in range(len(A[i])):
                #case1 -1st column -skip (j-1) as there is bound
                if j==0:
                    A[i][j]+=min(A[i-1][j],A[i-1][j+1])
                #case2 -last column -skip (j+1) as there is bound
                elif (j==len(A[i])-1):
                    A[i][j]+=min(A[i-1][j],A[i-1][j-1])
                #case3 -midcolumn -can take atmost 1 column ditance >>(-1,0,+1)
                else:
                    A[i][j]+=min(A[i-1][j],A[i-1][j+1],A[i-1][j-1])
                
                
        #return minimum of modified last row      
        return(min(A[len(A)-1]))
solved=Solution()
print(solved.minFallingPathSum([[1,2,3],[4,5,6],[7,8,9]]))