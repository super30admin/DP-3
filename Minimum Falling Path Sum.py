# Time complexity : O(m*n)
# Space complexity : O(1)

# The code ran on Leetcode
# Starting at index (1, 0), find the minimum connected element from the previous row and add it to the current element. The first row is not changed. The minimum path sum can be found in the last row.
# Check the boundaries to get the appropriate connected elements

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        n = len(matrix)

        for i in range(1, n):

            for j in range(n):

                temp_min = matrix[i-1][j]
                if j+1 < n and matrix[i-1][j+1] < temp_min:
                    temp_min = matrix[i-1][j+1]
                if j-1 >= 0 and matrix[i-1][j-1] < temp_min:
                    temp_min = matrix[i-1][j-1]

                matrix[i][j] += temp_min

        return min(matrix[-1])
