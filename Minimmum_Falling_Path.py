#Time Complexity : O(N) where N is number of inputs
#Space Complexity : O(m) where m is size of the inputs
class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        if len(A) == 0:
            return -1
        n = len(A)
        for i in range(1,n):
            for j in range(n):
                if j ==0:
                    A[i][j]=min(A[i-1][j],A[i-1][j+1])+A[i][j]
                elif j == n-1:
                    A[i][j]=min(A[i-1][j-1],A[i-1][j])+A[i][j]
                else:
                    A[i][j]=min(A[i-1][j],A[i-1][j+1],A[i-1][j-1])+A[i][j]
        print(A)
        
        K = float('inf')
        for i in range(n):
            K = min(K , A[n-1][i])
        return K
            
        