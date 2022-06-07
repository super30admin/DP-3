#TC:O(n)+O(k) where k=len(matrix[0]) and n is number of elements in matrix.
#SC:O(n)
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        min1=99999
        m1=0
        row=len(matrix)
        col=len(matrix[0])
        dp=[[0 for i in range(col+2)] for i in range(row)]
        dp[0][0]=99999
        dp[0][col+1]=99999
        for j in range(1,row+1):
            dp[0][j]=matrix[0][j-1]
        for i in range(1,row):
            for j in range(1,row+1):
                    dp[i][0]=99999
                    dp[i][-1]=99999
                    dp[i][j]=matrix[i][j-1]+min(dp[i-1][j-1:j+2])
                    
                    
        min1=min(dp[-1])            
  
        return min1
                    
                