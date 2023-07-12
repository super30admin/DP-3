# Time Complexity: O(n^2)
# Space Complexity: O(n^2)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        
        # Create a new matrix to store the minimum path sums
        dp = [[0] * n for _ in range(n)]
        
        # Copy the first row of the given matrix to the new matrix
        dp[0] = matrix[0]
        
        # Iterate through the remaining rows
        for i in range(1, n):
            for j in range(n):
                # Calculate the minimum path sum for each cell
                dp[i][j] = matrix[i][j] + min(
                    dp[i-1][j],  # Directly below
                    dp[i-1][j-1] if j-1 >= 0 else float('inf'),  # Diagonally left
                    dp[i-1][j+1] if j+1 < n else float('inf')  # Diagonally right
                )
        
        # Find the minimum sum in the last row
        min_sum = min(dp[n-1])
        
        return min_sum
