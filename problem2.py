#Space complexity: O(m*n)
#Time complexity: O(m*n)
#For each position, pick the mimimum from the previous row and add it with the current row value
#finally return the minimum elemtn in the last row.
class Solution:
    def minFallingPathSum(self, matrix) -> int:
        dp=[]
        if(len(matrix)==1):
            return matrix[0][0]
        for i in matrix:
            temp=[]
            for j in matrix[0]:
                temp.append(-1)
            dp.append(temp)
        for i in range(len(matrix[0])):
            dp[0][i]=matrix[0][i]
        
        for i in range(1,len(dp)):
            for j in range(len(dp[0])):
                if(j==0):
                    dp[i][j]=min(dp[i-1][j],dp[i-1][j+1])+matrix[i][j]
                elif(j==len(dp[0])-1):
                    dp[i][j]=min(dp[i-1][j],dp[i-1][j-1])+matrix[i][j]
                else:
                    dp[i][j]=min(dp[i-1][j],dp[i-1][j-1],dp[i-1][j+1])+matrix[i][j]
        return min(dp[-1])
s=Solution()
matrix = [[2,1,3],[6,5,4],[7,8,9]]
print(s.minFallingPathSum(matrix))
