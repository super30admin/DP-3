class Solution:
    
    def minFallingPathSum(self,matrix):
        n=len(matrix)

        for i in range(n-2,-1,-1):
            for j in range(n):
                down=matrix[i+1][j]
                left_down=matrix[i+1][j-1] if j>0 else float('inf')
                right_down=matrix[i+1][j+1] if j<n-1 else float('inf')
                matrix[i][j]+=min(down,left_down,right_down)

        return min(matrix[0])
    
sol=Solution()
print(sol.minFallingPathSum(matrix=[[2,1,3],[6,5,4],[7,8,9]]))
print(sol.minFallingPathSum(matrix=[[-19,57],[-40,-5]]))