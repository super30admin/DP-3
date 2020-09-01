// Time Complexity : O(N*N) for N*N matrix
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: using lowest sum dp and pain house problem.


class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        
        for i in range(1,len(A)):
            for j in range(0,len(A)):
                if j == 0:
                    A[i][j] += min(A[i-1][j], A[i-1][j+1])
                elif j == len(A)-1:
                    A[i][j] += min(A[i-1][j], A[i-1][j-1])
                else:
                    A[i][j] += min( min(A[i-1][j] , A[i-1][j+1]), A[i-1][j-1])
        
        return min(A[-1])
        
