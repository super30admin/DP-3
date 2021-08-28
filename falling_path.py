# // Time Complexity :O(n*m),n is the row and m is column of given matrix
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach




class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        print(matrix)
        for i in range(len(matrix)-2,-1,-1):
            for j in range(len(matrix[0])):
                
                if j==0:
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j],matrix[i+1][j+1])
                
                elif j==len(matrix[0])-1:
                    
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j],matrix[i+1][j-1])
                else:
                    matrix[i][j]=matrix[i][j]+min(matrix[i+1][j],matrix[i+1][j+1],matrix[i+1][j-1])
        return min(matrix[0])