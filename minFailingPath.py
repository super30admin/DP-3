"""
From second-last row, move upward, and update each cell as
matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1], matrix[i+1][j+1])
Keep check on boundary values to avoid index errors
Return min of the top row after processing
"""
"""
Time Compllexity: O(n^2) — each cell is visited once.
Space Complexity: O(1) — in-place
"""

class minFailingPath:
    def minFallingPathSum(self, matrix: list[list[int]]) -> int:

        n = len(matrix)

        for i in range(n - 2, -1, -1):
            for j in range(n):
                down = matrix[i + 1][j]
                left = matrix[i + 1][j - 1] if j > 0 else float('inf')
                right = matrix[i + 1][j + 1] if j < n - 1 else float('inf')
                matrix[i][j] += min(down, left, right)

        return min(matrix[0])
    
if __name__=="__main__":

    obj = minFailingPath()
    matrix = [[2,1,3],[6,5,4],[7,8,9]]
    print(obj.minFallingPathSum(matrix))
        