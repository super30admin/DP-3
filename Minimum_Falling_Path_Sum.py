# // Time Complexity : O(m*n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        i = len(matrix) -2
        while i>=0:
            j = 0
            while j <= len(matrix)-1:
                if j == 0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j],matrix[i+1][j+1])
                elif j == len(matrix)-1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j],matrix[i+1][j-1])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], min(matrix[i+1][j+1], matrix[i+1][j-1]) )
                j = j + 1
            i = i - 1
        return min(matrix[0])
                