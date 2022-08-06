
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        n = len(matrix)
        res = [0]*n
        for i in range(n):
            res[i] = matrix[n-1][i]
        for i in range(n-2,-1,-1):
            temp = [0]*n
            for j in range(n):
                if j == 0:
                    temp[j] = matrix[i][j] + min(res[j], res[j+1])
                elif j == n - 1:
                    temp[j] = matrix[i][j] + min(res[j], res[j-1])
                else:
                    temp[j] = matrix[i][j] + min(res[j], res[j-1], res[j+1])
            res = temp
        return min(res)