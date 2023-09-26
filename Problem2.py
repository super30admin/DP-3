'''
1. We need to find the minimum path from the beginning to the end. But it is also same path from the end to beginning.
2. We start from the last but one row and check whichever path below it is the minimum path considering both the first and last columns
3. We proceed further up by summing this minimum value for each row. When we reach the top we have the minimum sum at one of the cells in the top row. Return it.
'''
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:

        if matrix == None or len(matrix) == 0:
            return 0
        
        m = len(matrix)
        n = len(matrix[0])

        for i in range(m-2,-1,-1):
            for j in range(n):
                if j == 0:
                    print(min(matrix[i+1][j], matrix[i+1][j+1]))
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == n-1:
                    matrix[i][j] =  matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] =  matrix[i][j] + min(matrix[i+1][j],matrix[i+1][j-1],matrix[i+1][j+1])
        return min(matrix[0])