# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach:
# We break the problem into subproblems, where each subproblem considers an additional row to be
# added into the subproblem. We iteratively solve each subproblem, and then
# use the previous subproblem to solve the current one. Here, each subproblem is to identlfy
# the optimal path length if a particular row is added in addition to prev row.

class Solution:
    def minFallingPathSum(self, matrix) -> int:
        for row in range(1, len(matrix)):
            for col in range(len(matrix[0])):
                if col == 0:
                    matrix[row][col] += min(matrix[row - 1][col], matrix[row - 1][col + 1])
                elif col == len(matrix[0]) - 1:
                    matrix[row][col] += min(matrix[row - 1][col], matrix[row - 1][col - 1])
                else:
                    matrix[row][col] += min(matrix[row - 1][col], matrix[row - 1][col - 1], matrix[row - 1][col + 1])

        return min(matrix[len(matrix) - 1])

result = Solution()

print(result.minFallingPathSum([[1,2,3], [4,5,6], [7,8,9]]))