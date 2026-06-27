'''
The brute force solution is to traverse the gird from top to bottom resurcively and 
choose the minimum sum from the 3 paths from a given cell. The time complexity will be
O(3^n) and Space complexity will be O(n*m) where n is the total number of rows and m
is total number of columns.

This can be optimized by doing a top-bottom approach and use the intuition that the 
best path to reach to the cell is the minimum of the 3 paths from above.

Time complexity: O(n*m)
Space complexity: O(m)
'''
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        for i in range(1,rows):
            for j in range(cols):
                if j == 0:
                    matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j+1])

                elif j == cols-1:
                    matrix[i][j] += min(matrix[i-1][j-1], matrix[i-1][j])

                else:
                    matrix[i][j] += min(matrix[i-1][j-1], matrix[i-1][j], matrix[i-1][j+1])

        return min(matrix[-1])
