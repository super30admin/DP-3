# Time complexity: O(r*c)
# Space complexity: O(1)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        # check if the array is empty or not
        if matrix is None or len(matrix) == 0:
            return 0
        
        # row
        r = len(matrix)
        # col
        c = len(matrix[0])
        
        # traverse the matrix
        for i in range(1,r):
            for j in range(c):
                # edge cases (j = 0, j = c-1)
                # choose min only from 2 elements
                if j == 0:
                    matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j+1])
                # choose min only from 2 elements
                elif j == c-1:
                    matrix[i][j] += min(matrix[i-1][c-2], matrix[i-1][c-1])
                # otherwise choose min from 3 adjacent elements
                else:
                    matrix[i][j] += min(matrix[i-1][j-1], matrix[i-1][j], matrix[i-1][j+1])
        # return the min in c-1 row as the solution
        return min(matrix[c-1])