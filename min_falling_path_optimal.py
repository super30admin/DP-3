# // Time Complexity :O(m*n)
# // Space Complexity :O(1)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        for i in range(1,len(matrix)):
            for j in range(len(matrix[0])):
                if j==0:
                    matrix[i][j]+=min(matrix[i-1][j],matrix[i-1][j+1])
                elif j==len(matrix)-1:
                    matrix[i][j]+=min(matrix[i-1][j],matrix[i-1][j-1])
                else:
                    matrix[i][j]+=min(matrix[i-1][j],matrix[i-1][j+1],matrix[i-1][j-1])
        return min(matrix[-1])