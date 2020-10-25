"""
Time Complexity : O(n^2) 
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
This problem is similar to house paint problem. Here also, we know that, at every value, we can choose
minimum from left column, same column or right column of previous row. This bowls down to house paint 
problem. So we use the similar algorithm to solve it.
"""


class Solution(object):
    def minFallingPathSum(self, A):
        m = len(A)
        for i in range(1, m):
            for j in range(m):
                if j == 0:
                    A[i][j] += min(A[i-1][j], A[i-1][j+1])
                elif j == m-1:
                    A[i][j] += min(A[i-1][j-1], A[i-1][j])
                else:
                    A[i][j] += min(A[i-1][j-1], A[i-1][j], A[i-1][j+1])
        return(min(A[-1]))
