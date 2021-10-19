#Time Complexity : O(n^2)
#Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        minv = 1000
        n = len(matrix)
        if n == 1:
            return matrix[0][0]
        for i in range(1, n):
            for j in range(n):
                if j == 0:
                    matrix[i][j] += min(matrix[i-1][j],matrix[i-1][j+1])
                elif j == n-1:
                    matrix[i][j] += min(matrix[i-1][j],matrix[i-1][j-1])
                else:
                    matrix[i][j] += min(matrix[i-1][j],matrix[i-1][j+1], matrix[i-1][j-1])
                if i==n-1:
                    minv = min(minv, matrix[i][j])
        
        return minv