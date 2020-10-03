# Time Complexity O(N*M)
# Space Complexity O(1)
# Leetcode all test cases passed: Yes
# Any difficulties: No

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if not A:
            return 0
        row = len(A)
        col = len(A[0])
        
        for i in range(1, row):
            for j in range(col):
                if j==0:
                    A[i][j]+=min(A[i-1][j], A[i-1][j+1])
                elif j==col-1:
                    A[i][j]+=min(A[i-1][j], A[i-1][j-1])
                else:
                    A[i][j]+=min(A[i-1][j-1], A[i-1][j], A[i-1][j+1])
        return min(A[row-1])
