# Using DP
# Time and Space Complexity = O(m*n)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        result = 999999
        dp = [[0 for _ in range(len(matrix[0]))] for _ in range(len(matrix))]
        dp[-1] = matrix[-1]
        for i in range(len(matrix)-2,-1,-1):
            for j in range(len(matrix[0])):
                print(i,j)
                if j==0:
                    dp[i][j] = min(matrix[i][j]+dp[i+1][j],matrix[i][j]+dp[i+1][j+1])
                elif j == len(matrix[0])-1:
                    dp[i][j] = min(matrix[i][j]+dp[i+1][j],matrix[i][j]+dp[i+1][j-1])
                else:
                    dp[i][j] = min(matrix[i][j]+dp[i+1][j],matrix[i][j]+dp[i+1][j-1],matrix[i][j]+dp[i+1][j+1])
        print(dp)
        for j in range(len(matrix[0])):
            result = min(dp[0][j],result)
        return result



        