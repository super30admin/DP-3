# // Time Complexity : O(n*m) = O(n^2)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Similar to house paint problem


class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if not A:
            return 0
        m = len(A)
        n = len(A[0])
        Value = 0
        for i in range(1,m):
            for j in range(0,n):
                #Begin
                if j == 0:
                    A[i][j] = A[i][j] + min(A[i-1][j+1],A[i-1][j])
                #End
                elif j == n - 1:
                    A[i][j] = A[i][j] + min(A[i-1][j-1],A[i-1][j])    
                    
                #Mid
                else:
                    A[i][j] = A[i][j] + min(A[i-1][j-1],A[i-1][j],A[i-1][j+1])
        return min(A[-1])