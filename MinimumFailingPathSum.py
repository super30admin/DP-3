'''
TC: O(m*n) where m is the number of input
SC: O(n) is length of 1 row
'''
from typing import List

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        res = [0]*(len(matrix[0]))
        if len(res) == 1:
            return matrix[0][0]
        for i in range(len(matrix)-1,-1,-1):
            for j,v in enumerate(matrix[i]):
                if j == 0:
                    matrix[i][j] = matrix[i][j] + min(res[j], res[j+1])
                elif j == len(matrix[i])-1:
                    matrix[i][j] = matrix[i][j] + min(res[j-1], res[j])
                else:
                    matrix[i][j] = matrix[i][j] + min(res[j-1], res[j], res[j+1])
            res = matrix[i]
        return min(res)
s = Solution()
print(s.minFallingPathSum([[2,1,3],[6,5,4],[7,8,9]]))
print(s.minFallingPathSum([[-19,57],[-40,-5]]))
print(s.minFallingPathSum([[-48]]))