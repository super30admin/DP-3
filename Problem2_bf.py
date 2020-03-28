#
# Time complexity = O(3^n) where n is size of A
# Space complexity = O(n)
# TLE on leetcode
#

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        def helper(x, y, val):
            if y == len(A):
                return val
            if x < 0 or x >= len(A):
                return float("inf")
            return min(min(helper(x+1, y+1, val+A[y][x]), helper(x-1, y+1, val+A[y][x])),
                       helper(x, y+1, val+A[y][x]))
        res = float("inf")
        for i in range(len(A)):
            res = min(res, helper(i, 0, 0))
        return res
