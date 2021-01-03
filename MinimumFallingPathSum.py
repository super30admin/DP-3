# Time Complexity : O(N^2)
# Space Complexity : O(1) modifying in place
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Used DP as there are repeated subproblems in binary tree


class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if len(A) == 0:
            return 0
        if len(A) == 1:
            return min(A[0])

        for i in range(len(A) - 1, -1, -1):
            for j in range(len(A[0])):
                if j == 0:
                    A[i - 1][j] += min(A[i][j], A[i][j + 1])
                elif j == len(A[0]) - 1:
                    A[i - 1][j] += min(A[i][j - 1], A[i][j])
                else:
                    A[i - 1][j] += min(A[i][j - 1], A[i][j], A[i][j + 1])

        return min(A[0])