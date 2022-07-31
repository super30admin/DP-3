# Time complexity: O(n^2)
# Space complexity: O(1)
# Approach: from last second row, 
# add the present index value to minimum of (below rows neighbour column's index's values) until first row
# return the smallest element in the first row



class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        for i in range(n-2, -1, -1):
            for j in range(0, n):
                if j == 0:
                    matrix[i][j] = min(matrix[i+1][j], matrix[i+1][j+1])+matrix[i][j]


                elif j == n-1:
                    matrix[i][j] = min(matrix[i+1][j], matrix[i+1][j-1])+matrix[i][j]


                else:
                    matrix[i][j] = min(matrix[i+1][j], matrix[i+1][j+1],matrix[i+1][j-1])+matrix[i][j]
        mini = math.inf
        for j in range(0,n):
            mini = min(mini, matrix[0][j])
        return mini
            
        