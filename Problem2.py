# Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
#Time Complexity: O(n^2), where n is the number of rows (equal to number of columns since matrix is n*n). We visit every cell exactly once with two nested loops, doing O(1) work per cell.
#Space Complexity: O(1) auxiliary space. We update the input matrix in place instead of using a separate DP array, so no extra memory is used beyond a few variables.
#Approach:
#This is a bottom up dynamic programming problem. The minimum path sum ending at any cell equals that cell's own value plus the minimum of the three cells above it that could fall into it (up left, straight up, up right).
#We do not touch row 0 since a path starting there has no cells above it to add from.
#Starting from row 1, we update each cell to represent the minimum sum of any path that ends at that cell. 
#By the time we reach the last row, each cell holds the minimum path sum ending there, so the final answer is just the smallest value in that last row.

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        rows = len(matrix)

        # Start from row 1 since row 0 has no row above it
        # if we started at row 0, matrix[r-1] would become matrix[-1] and wrongly wrap to the last row
        for r in range(1, rows):
            for c in range(rows):
                # value from the up left diagonal
                # if c is 0 there is no left diagonal so we use infinity so it never gets picked by min
                left = matrix[r-1][c-1] if c > 0 else float('inf')

                # value directly above, this always exists so no bounds check needed
                mid = matrix[r-1][c]

                # value from the up right diagonal
                # if c is the last column there is no right diagonal so we use infinity
                right = matrix[r-1][c+1] if c < rows-1 else float('inf')

                # add the current cell value to the cheapest of the three paths coming from above
                # this overwrites the cell to now store the minimum path sum ending here
                matrix[r][c] = matrix[r][c] + min(left, right, mid)

        # last row now holds the minimum path sum ending at each column
        # the overall answer is the smallest value among those
        return min(matrix[-1])