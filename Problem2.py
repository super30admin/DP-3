class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        
        if A == None or len(A) == 0 or len(A[0]) == 0:
            return 0
                
        for i in range(1,len(A)):
            for j in range(len(A[0])):
                if j == 0:
                    A[i][j] += min(A[i-1][j], A[i-1][j+1])
                elif j == len(A[0])-1:
                    A[i][j] += min(A[i-1][j-1], A[i-1][j])
                else: 
                    A[i][j] += min(A[i-1][j-1], A[i-1][j], A[i-1][j+1])

        return min(A[-1])
#Time Complexity = O(N*n)
#Space Complexity = O(1)