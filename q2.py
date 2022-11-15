from typing import List
import sys
# Time Complexity : O(m*n), Where m is number of rows in matrix, n is number of columns in matrix
# Space Complexity : O(m*n), Where m is number of rows in matrix, n is number of columns in matrix
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

class Solution:
    def actsol(self,row,col,n,matrix,memo):
        #This is the base case where go beyond the rows, We have to return 0
        if(row>n-1):
            return 0
        
        if(memo[row][col]!=None):
            return memo[row][col]
        #This is the actual logic
        if(row<=n-1):
            if(col==0):
                #If we are at the first column, Then we have to consider only two columns they are below and right
                choice1=self.actsol(row+1,col,n,matrix,memo)
                choice2=self.actsol(row+1,col+1,n,matrix,memo)
                #print(choice1,choice2)
                a=min(choice1,choice2)
            if(col==n-1):
                #If we are at last column, Then we have to consider only two columns they are below and left
                choice1=self.actsol(row+1,col-1,n,matrix,memo)
                choice2=self.actsol(row+1,col,n,matrix,memo)
                #print(choice1,choice2)
                a=min(choice1,choice2)
            if(col>0 and col<n-1):
                #If we are in between, Then we have to consider three columns they are left, below and right
                choice1=self.actsol(row+1,col-1,n,matrix,memo)
                choice2=self.actsol(row+1,col,n,matrix,memo)
                choice3=self.actsol(row+1,col+1,n,matrix,memo)
                #print(choice1,choice2,choice3)
                a=min(choice1,choice2,choice3)
        memo[row][col]=matrix[row][col]+a
        return memo[row][col]
        
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        memo=[[None for i in range(len(matrix))] for j in range(len(matrix))] 
        #print(memo)
        for i in range(len(matrix)):
            self.actsol(0,i,len(matrix),matrix,memo)
        #print(memo)
        output=sys.maxsize
        for i in range(len(matrix)):
            if(memo[0][i]<output):
                output=memo[0][i]
        #print(output)
        return output
        