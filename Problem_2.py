# Time Complexity: O(n^2)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        path = len(matrix)
        for i in range(1, path):
            for j in range(path):
                minsum = float("inf")
                for k in range(max(0, (j - 1)), min(path, (j + 2))):
                    minsum = min(minsum, matrix[i - 1][k])
                matrix[i][j] += minsum
        return min(matrix[-1])