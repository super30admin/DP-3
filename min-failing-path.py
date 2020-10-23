# Time Complexity: O(n*n) where A has n cols and n rows
# Space Complexity: O(1) - using input array as dp array
# Did it run on Leetcode: Yes
# Did you face any issues: No
# Approach:
#     - Decrease and conquer the problem
#     - Define an objective function f(i,j) as the minimum cost at any index i,j
#     - This depends on the values the previous row that differ by +/-1
#     - f(i,j) = min(f(i-1, j), f(i-1, j-1), f(i-1,j))

class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        # Using input array as dp array
        for i in range(1, len(A)):
            for j in range(len(A[0])):
                if j == 0:  # Left boundary, consider only j and j+1
                    candidate = min(A[i-1][j], A[i-1][j+1])
                elif j == len(A[0])-1:  # Right boundry
                    candidate = min(A[i-1][j-1], A[i-1][j])
                else:
                    candidate = min(A[i-1][j-1], A[i-1][j], A[i-1][j+1])
                A[i][j] += candidate

        return min(A[-1])
