# Time Complexity : O(m*n)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

class Solution:
    def minFallingPathSum(self, matrix) -> int:
        if len(matrix)==0:
            return 0
        
        for i in range(1,len(matrix)):
            for j in range(0,len(matrix)):
                if j==0:
                    matrix[i][j] = matrix[i][j]+min(matrix[i-1][j],matrix[i-1][j+1])
                elif j==len(matrix)-1:
                    matrix[i][j] = matrix[i][j]+min(matrix[i-1][j],matrix[i-1][j-1])
                else:
                    matrix[i][j] = matrix[i][j]+min(matrix[i-1][j],matrix[i-1][j-1],matrix[i-1][j+1])
                    
        minimum = 9999999
        for i in range(len(matrix)):
            minimum = min(minimum,matrix[len(matrix)-1][i])
        return minimum

matrix = [[82,81],[69,33]]
obj = Solution()
print(obj.minFallingPathSum(matrix))