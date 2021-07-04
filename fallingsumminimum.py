#https://leetcode.com/problems/minimum-falling-path-sum/submissions/
#time-o(m*n)
#space-o(1)
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        print(matrix[0])
        print(matrix)
        for i in range(len(matrix)-2,-1,-1):
            for j in range(0,len(matrix[i])):
                if j==0:
                    matrix[i][j]+=min(matrix[i+1][j],matrix[i+1][j+1])
                elif j==len(matrix[0])-1:
                    matrix[i][j]+=min(matrix[i+1][j],matrix[i+1][j-1])
                else:
                    matrix[i][j]+=min(matrix[i+1][j],matrix[i+1][j+1],matrix[i+1][j-1])         
        return min(matrix[0])
                

                