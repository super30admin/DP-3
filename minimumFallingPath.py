# Time Complexity O(n^2)
class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if not A:
            return 0
        else:
            for i in range(1,len(A)):
                for j in range(len(A[0])):
                    if j == 0:
                        A[i][j] = A[i][j] + min(A[i-1][j], A[i-1][j+1])

                    elif j == (len(A[0]) -1):
                        A[i][j] = A[i][j] + min(A[i-1][j], A[i-1][j-1])

                    else:
                         A[i][j] = A[i][j] + min(A[i-1][j], A[i-1][j-1], A[i-1][j+1])

            return min(A[len(A)-1])
