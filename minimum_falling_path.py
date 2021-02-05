# O(N * N) TIME AND O(N) SPACE WHERE N IS LEN(MATRIX)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix) == 0:
            return 0
        previous_row = matrix[0][:]
        for i in range(1,len(matrix)):
            current_row = [None for _ in range(len(matrix[0]))]
            for j in range(len(matrix[0])):
                if j == 0:
                    current_row[j] = matrix[i][j] + min(previous_row[j],previous_row[j+1])
                elif j == len(matrix[0])-1:
                    current_row[j] = matrix[i][j] + min(previous_row[j],previous_row[j-1])
                else:
                    current_row[j] = matrix[i][j] + min(previous_row[j],previous_row[j+1],previous_row[j-1])
            previous_row = current_row[:]
        return min(previous_row)