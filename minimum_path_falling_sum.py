# Time Complexity: O(N^2), where N is the length of A.
# Space Complexity: O(1) in additional space complexity. 

# Yes, it ran on Leetcode successfully
# Problems: No

class Solution(object):
    def minFallingPathSum(self, A):

        row = len(A)
        col = row
        
        for r in range(1,row):
            for c in range(col):
                if c==0:
                    A[r][c] += min(A[r-1][c],A[r-1][c+1])
                elif c==col-1:
                    A[r][c] += min(A[r-1][c-1],A[r-1][c])
                else:
                    A[r][c] += min(A[r-1][c-1],A[r-1][c],A[r-1][c+1])
        return min(A[-1])