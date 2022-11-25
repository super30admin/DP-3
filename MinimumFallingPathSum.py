"""
    Problem Statement: Minimium Falling Path Sum

    Time complexity: O(n^2)

    Space complexity: O(1)

    Accepted on LeetCode? Yes! 

    LeetCode Link: https://leetcode.com/problems/minimum-falling-path-sum/
"""

from typing import List

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n, m = len(matrix), len(matrix[0])
        for i in range(n-2, -1, -1):
            for j in range(m):
                if j == 0:
                    matrix[i][j] += min(matrix[i + 1][j], matrix[i + 1][j + 1])
                elif j == m - 1:
                    matrix[i][j] += min(matrix[i + 1][j-1], matrix[i + 1][j])
                else:
                    matrix[i][j] += min(matrix[i + 1][j-1], matrix[i + 1][j], matrix[i + 1][j + 1])
        return min(matrix[0])

if __name__ == "__main__":
    sol = Solution()
    matrix = [[2,1,3],[6,5,4],[7,8,9]]
    
    ret = sol.minFallingPathSum(matrix)
    assert ret == 13