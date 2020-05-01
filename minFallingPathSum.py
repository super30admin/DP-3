#Time Complexity=O(m*n)m-length of A, n-length of A[0]
#Space Complexity-O(m*n)
#we first initialize a 2D DP matrix, and then iterate the original matrix row by row. For each element in DP matrix, we sum up the corresponding element from original matrix with the minimum neighbors from previous row in DP matrix.Here instead of using a new matrix I have made computations in the existing one. Does this alter my SPACE COMAPLEXITY ? I guess it will be still O(m*n). Correct me if I am wrong. 


class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        
        if len(A)==0 or len(A[0])==0:
            return 0
        m=len(A)
        n=len(A[0])
      
                
        for i in range(1,m):
            for j in range(n):
                if j==0:
                    A[i][j]+=min(A[i-1][j+1],A[i-1][j])
                elif j==n-1:
                    A[i][j]+=min(A[i-1][j-1],A[i-1][j])
                else:
                    A[i][j]+=min(A[i-1][j-1],A[i-1][j],A[i-1][j+1])
        return min(A[-1])

