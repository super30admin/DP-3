'''
Approach:
We use bottom-up dynamic programming to calculate the minimum falling path sum. Starting from the second-last row,
we update each cell by adding the minimum of the reachable values from the row directly below (straight down, down-left, or down-right).
We modify the input matrix in-place to store intermediate results, and finally return the minimum value from the top row.

Time Complexity: O(m*n)
Space Complexity: O(1)
'''
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m, n = len(matrix), len(matrix[0])

        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if ((i == m-1 and j == n-1) or (i==m-1)):
                    continue
                elif j == n-1:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
                elif j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                else:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1], matrix[i+1][j-1])

        result = matrix[0][0]

        for j in range(n):
            result = min(result, matrix[0][j])
            
        return result