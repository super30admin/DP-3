## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        """
        Time Complexity: O(N^2), where N is the number of rows (and columns) in the matrix.
                         We iterate through almost every cell in the NxN matrix exactly once.
        Space Complexity: O(1) auxiliary space. We modify the input matrix in-place to store 
                          our intermediate results, so no extra proportional memory is allocated.
        """
        rows = len(matrix)
        
        # We start from the second row (index 1) because the minimum falling path sum 
        # to reach any cell in the first row is just the value of the cell itself.
        for r in range(1, rows):
            for c in range(rows):
                
                # Fetch the three possible paths from the row directly above:
                # 1. Left diagonal (check bounds to ensure we don't wrap around)
                left = matrix[r - 1][c - 1] if c > 0 else float('inf')
                
                # 2. Directly above
                mid = matrix[r - 1][c]
                
                # 3. Right diagonal (check bounds)
                right = matrix[r - 1][c + 1] if c < rows - 1 else float('inf')
                
                # Update the current cell to store the minimum sum required to reach it.
                # This builds our optimal substructure moving downwards.
                matrix[r][c] = matrix[r][c] + min(left, mid, right)
        
        # After processing all rows, the last row contains the minimum path sums 
        # ending at each respective column. The answer is simply the smallest one.
        return min(matrix[-1])