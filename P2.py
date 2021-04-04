# -*- coding: utf-8 -*-
"""
Created on Sun Apr  4 11:36:06 2021

@author: jgdch
"""

# Time Complexity: O(M*N), M is the number of columns , N is the number of rows
#Space Complexity: O(1)
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        for i in range(1,len(matrix)):
            for j in range(len(matrix[0])):
                if(j==0):
                    matrix[i][j]+=min(matrix[i-1][j],matrix[i-1][j+1])
                elif(j==(len(matrix[0])-1)):
                    matrix[i][j]+=min(matrix[i-1][j],matrix[i-1][j-1])
                else:
                    matrix[i][j]+=min(matrix[i-1][j-1],matrix[i-1][j],matrix[i-1][j+1])
        
        min_element=float("Inf")
        for i in range(len(matrix[0])):
            if(matrix[len(matrix)-1][i]<min_element):
                min_element=matrix[len(matrix)-1][i]
        return min_element
                
                    
        