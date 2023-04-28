#Time Complexity:O(n)
#Space Complexity:O(1)
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        n=len(matrix)
        for i in range(m-2,-1,-1):
            for j in range(n):
                if j==0:
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j],matrix[i+1][j+1])
                elif j==n-1:
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j],matrix[i+1][j-1])
                else:
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j],matrix[i+1][j-1],matrix[i+1][j+1])
        return min(matrix[0])