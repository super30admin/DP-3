#Time Complexity :O(n)
#Space Complexity :O(1) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : tried running sum.
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        if(matrix==None or len(matrix)==0):
            return 0
        
        for i in range(len(matrix)-2,-1,-1):
            for j in range(len(matrix)):
                if(j==0):
                    matrix[i][j]= matrix[i][j]+min(matrix[i+1][0],matrix[i+1][j+1])
                elif(j==len(matrix)-1):
                    matrix[i][j]+=min(matrix[i+1][j],matrix[i+1][j-1])
                else:
                    matrix[i][j]+=min(matrix[i+1][j],matrix[i+1][j-1],matrix[i+1][j+1])
        return min(matrix[0])
                