class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if not A: #edge case
            return 0
        for i in range(1, len(A)):
            for j in range(len(A[0])):
                if j<1:
                    A[i][j] = A[i][j]+min(A[i-1][j], A[i-1][j+1])
                elif j==len(A[0])-1:
                    A[i][j] = A[i][j]+min(A[i-1][j-1], A[i-1][j])
                else:
                    A[i][j] = A[i][j]+min(A[i-1][j-1], A[i-1][j], A[i-1][j+1])
        return min(A[-1])

#time complexity - O(n*m) as we iterate though every row and column
#space complexity - O(1) as we return the data structure used

#all test cases passed