#Time Complexity: O(m*n)
#Space Complexity: O(1)
#Successfully ran on leetcode

class Solution:
    def minFallingPathSum(self, matrix: list(list(int))) -> int:
        if len(matrix)==0:
            return 0
        rows = len(matrix)
        cols = len(matrix[0])
        for i in range(rows-2,-1,-1):
            for j in range(cols):
                if j==0:
                    matrix[i][j]+=min(matrix[i+1][j],matrix[i+1][j+1])
                elif j==cols-1:
                    matrix[i][j]+=min(matrix[i+1][j],matrix[i+1][j-1])
                else:
                    matrix[i][j]+=min(matrix[i+1][j-1],matrix[i+1][j],matrix[i+1][j+1])
        return min(matrix[0])
        