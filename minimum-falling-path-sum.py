class Solution:
    def minFallingPathSum(self, matrix) -> int:
        for i in range(1, len(matrix)):
            smallest_two = heapq.nsmallest(2, matrix[i - 1])
            for j in range(len(matrix[0])):
                matrix[i][j] += smallest_two[1] if matrix[i - 1][j] == smallest_two[0] else smallest_two[0]
        return min(matrix[-1])

