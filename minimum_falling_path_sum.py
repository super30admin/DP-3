class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        # start from the bottom and then go up as you fill the rows
        # go through each cell and add the minimum from bottom row
        # bottom up appraoch
        n = len(matrix)
        # create an empty matrix of same size
        paths = [[0 for x in range(n)] for y in range(n)]

        # in this case, you start at the top of the matrix and work row by row down.
        paths[0] = matrix[0]
        
        for i in range(1, n):
            for j in range(n):
                if 0 < j < n - 1:
                    paths[i][j] = min(paths[i-1][j-1], paths[i-1][j], paths[i-1][j+1]) + matrix[i][j]
                elif j == 0:
                    paths[i][j] = min(paths[i-1][j], paths[i-1][j+1]) + matrix[i][j]
                else:
                    paths[i][j] = min(paths[i-1][j-1], paths[i-1][j]) + matrix[i][j]

        return min(paths[-1])