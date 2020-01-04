# -*- coding: utf-8 -*-
"""
Created on Sat Jan  4 17:40:10 2020

@author: WELCOME
"""
"""
Time Complexity = O(M*N) where M is number of rows and N in number of columns
Space Complexity = O(1) as I manipulated the given array
"""

class Solution:
    def minFallingPathSum(self, A):
        for i in range(1,len(A)):
            for j in range(len(A[0])):
                if j==0:
                    A[i][j]=A[i][j]+min(A[i-1][j],A[i-1][j+1])
                elif j==len(A[0])-1:
                    A[i][j]=A[i][j]+min(A[i-1][j-1],A[i-1][j])
                else:
                    A[i][j]=A[i][j]+min(A[i-1][j-1],A[i-1][j],A[i-1][j+1])
        minimum=float('inf')
        for i in A[-1]:
            if i<minimum:
                minimum=i    
        return minimum
    
temp=Solution()
temp.minFallingPathSum([[1,2,3],[4,5,6],[7,8,9]])