
''' 
Time complexity :O(N^2)
Space complexity : O(1)
'''

class Solution:
    def minFallingPathSum(self, A) -> int:
        
        if not A:
            return 0
        
        for i in range(1,len(A)):
            for j in range(len(A[0])):
                if j==0:
                    A[i][j]+= min(A[i-1][j],A[i-1][j+1])
                elif j == len(A) - 1:
                    A[i][j] += min(A[i-1][j],A[i-1][j-1])
                else:
                    A[i][j]+= min(A[i-1][j],A[i-1][j-1],A[i-1][j+1])
        
        mini = float('inf')
        size = len(A) -1
        for i in range(len(A)):
            if A[size][i] < mini:
                mini = A[size][i]
        return mini


s = Solution()
print(s.minFallingPathSum([[1,2,3],[4,5,6],[7,8,9]]))