# Time complexity O(n^2) n is the size of the matrix
# Space complexity O(1) because updating source matrix

class Solution:
    def minFallingPathSum(self, matrix: list[list[int]]) -> int:
        # self.helper(matrix, 1)
        for idx in range(1, len(matrix)):
            for i in range(len(matrix)):
                below = matrix[idx][i] + matrix[idx - 1][i]
                ele = matrix[idx][i]
                if i == 0:
                    matrix[idx][i] = min(below, ele + matrix[idx-1][i+1])
                elif i == len(matrix) - 1:
                    matrix[idx][i] = min(below, ele + matrix[idx-1][i-1])
                else:
                    matrix[idx][i] = min(below, min(
                        ele + matrix[idx-1][i-1], ele + matrix[idx-1][i+1]))
        return min(matrix[len(matrix)-1])

    def helper(self, matrix, idx):
        if idx == len(matrix):
            return

        # check each element of a row
        for i in range(len(matrix)):
            below = matrix[idx][i] + matrix[idx - 1][i]
            ele = matrix[idx][i]
            if i == 0:
                matrix[idx][i] = min(below, ele + matrix[idx-1][i+1])
            elif i == len(matrix) - 1:
                matrix[idx][i] = min(below, ele + matrix[idx-1][i-1])
            else:
                matrix[idx][i] = min(below, min(
                    ele + matrix[idx-1][i-1], ele + matrix[idx-1][i+1]))
        self.helper(matrix, idx + 1)
        return
