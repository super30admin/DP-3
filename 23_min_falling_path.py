# S30 Big N Problem #23 {Medium}
# Leetcode #931

# It is given in the question that you are having an array of integers A. 
# you have to calculate the minimum falling path through A. 
# A falling path starts at any element in the first row , and must choose one element from each row and make sure to choose element from next row from a column whcih is different from the previous row's column by atmost one. 

# Time Complexity : O(n*m) n= no. of elements in each array, m=no. of arrays
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach:
# Based on the mentioned conditions, calculate the min. path for every row. 
# Consider the corner cases for 1st and last column. 

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        
        for i in range(1,len(A),1):
            for j in range(len(A[0])):
                if j==0:
                    A[i][j]=A[i][j]+min(A[i-1][0],A[i-1][1]) 
                elif j==(len(A[0])-1):
                    A[i][j]=A[i][j]+min(A[i-1][j],A[i-1][j-1])  
                else:
                    A[i][j]=A[i][j]+min(A[i-1][j-1],A[i-1][j],A[i-1][j+1])
                    
        
        return min(A[len(A)-1])
                    
                    
                
                
        