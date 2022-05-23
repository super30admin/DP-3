# Time Complexity : O(n*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        for i in range(1,len(matrix)):
            for j in range(len(matrix[0])):
                left = matrix[i-1][j-1] if (j-1) >= 0 else float("inf")
                same = matrix[i-1][j]
                right = matrix[i-1][j+1] if j+1<len(matrix[0]) else float("inf")
                matrix[i][j] = matrix[i][j] + min(left,min(same,right))
        minSum = float("inf")
        for num in matrix[-1]:
            if num < minSum:
                minSum = num
        return minSum