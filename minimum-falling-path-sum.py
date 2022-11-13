#TC: O(n)
#SC: O(1)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        for i in range(1,len(matrix)):
            for j in range(len(matrix[i])):
                opt1=matrix[i-1][j]
                opt2,opt3=10**4,10**4
                if j-1>=0: opt2 = matrix[i-1][j-1]
                if j+1<len(matrix[i]): opt3 = matrix[i-1][j+1]
                matrix[i][j]+=min(opt1,opt2,opt3)

        return min(matrix[-1])