# // Time Complexity : O(n*n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nothing 


# // Your code here along with comments explaining your approach
# DP solution
# from second row change the values by taking min from above row 
# consider only j,j-1, j+1 in above row
# return min from last row



class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        for i in range(1, len(matrix)):
            for j in range(len(matrix)):
                
                if j == 0:
                    matrix[i][j] += min (matrix[i-1][j], matrix[i-1][j+1])
                elif j == len(matrix)-1:
                    matrix[i][j] += min (matrix[i-1][j], matrix[i-1][j-1])
                else:
                    matrix[i][j] += min (matrix[i-1][j], matrix[i-1][j+1], matrix[i-1][j-1])
        
        return min(matrix[len(matrix)-1])
                    
                    
            
        