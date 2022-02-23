# // Time Complexity : O(n^2)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        n = len(matrix)
        
        # start from the first row 
        for i in range(1,n):
            for j in range(n):
                
                # if at the first column
                if j == 0:
                    matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j+1])
                
                # if at the last column
                elif j == n-1:
                    matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j-1])
        
                else:
                    matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j-1], matrix[i-1][j+1])
                    
            # after computing pointer stands at the last row
        return min(matrix[n-1])