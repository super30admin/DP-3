#931. Minimum Falling Path Sum
"""
Time Complexity : O(n^2)
Space Complexoty : O(n)
"""
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        prev = matrix[-1]
        
        for i in range(n-2, -1, -1):
            curr = matrix[i]
            curr[0] += min(prev[0], prev[1])
            curr[-1] += min(prev[-1], prev[-2])
            for j in range(1, n-1):
                curr[j] += min(prev[j-1], prev[j], prev[j+1])
            prev = curr
        
        return min(prev)
