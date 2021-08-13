# Time Complexity: O(MN) where m x n is the dimension of the matrix
# Space Complexity: O(1) since we modify the passed matrix.
def minFallingPathSum(matrix: list[list[int]]) -> int:
    if matrix is None or len(matrix) == 0:
        return 0
    m = len(matrix)
    n = len(matrix[0])
    for i in range(1, m):
        for j in range(n):
            if j == 0:
                # minimum of the two immediate cells above i,j
                matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j+1])
            elif j == n-1:
                matrix[i][j] += min(matrix[i-1][j-1], matrix[i-1][j])
            else:
                matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j-1], matrix[i-1][j+1])
    return min(matrix[-1]) # Time complexity for min is O(N) since we look at the indices