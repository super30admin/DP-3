#Time Complexity: O(n2)
#Space Complexity: O(1)
class Solution:
    def minFallingPathSum(self, mat: List[List[int]]) -> int:
        n = len(mat)
        m = len(mat[0])
        
        for i in range(1,n):
            for j in range(m):
                min_v = mat[i][j] + mat[i-1][j] #next row
                if j-1>=0:
                    min_v = min(min_v,mat[i][j] + mat[i-1][j-1]) #left diagonal
                if j+1<m:
                    min_v = min(min_v,mat[i][j] + mat[i-1][j+1]) #Right Diagonal
                mat[i][j] = min_v
        return min(mat[-1])