#Time Complexity = O(n*m)
#Space Complexity = O(n*m)
#Compiled and run on leetcode



class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if (matrix == None and len(matrix) == 0 and len(matrix[0]) == 0):
            return 0

        n = len(matrix)  # rows
        m = len(matrix[0])  # cols

        for i in range(1, n):
            for j in range(0, m):
                if (j == 0): #1st col
                    matrix[i][j] += min(matrix[i - 1][j], matrix[i - 1][j + 1])
                elif (j == m - 1): #last col
                    matrix[i][j] += min(matrix[i - 1][j], matrix[i - 1][j - 1])
                else: #any in between col
                    matrix[i][j] += min(matrix[i - 1][j - 1], matrix[i - 1][j], matrix[i - 1][j + 1])

        minimum = float("inf") #ret min among the obtained paths
        for x in (matrix[n - 1]):
            if x < minimum:
                minimum = x

        return minimum