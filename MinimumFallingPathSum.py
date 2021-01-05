# // Time Complexity : O(nxn) where n is the no of rows/column in the square matrix
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if(A==[] or len(A)==0):
            return 0
        for i in range(1,len(A)):
            for j in range(len(A[0])):
                if(j==0):
                    A[i][j]=A[i][j]+min(A[i-1][j],A[i-1][j+1])
                elif(j==len(A[0])-1):
                    A[i][j]=A[i][j]+min(A[i-1][j],A[i-1][j-1])
                else:
                    A[i][j]=A[i][j]+min(A[i-1][j],A[i-1][j-1],A[i-1][j+1])
        min1=999
        for j in range(len(A[0])):
            min1=min(A[len(A)-1][j],min1)
        return min1