#Time Complexity : O(m*n)
#Space Complexity : O(col)
#Did this code successfully run on Leetcode :
#Any problem you faced while coding this : No

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        rows = len(matrix)
        col = len(matrix[0])
        dp = [0] * (col)
        if len(matrix) == 1:
            return matrix[0][0]

        dp2 = []
        flag = 0
        
        for i in range(rows -2,-1,-1):
            dp = matrix[i+1]
            if flag == 0:
                for k in range(col):
                    dp2.append(matrix[i+1][k])
            for j in range(0,col):
                if j - 1 >= 0 and j + 1 < col:
                    dp[j] = matrix[i][j] + min(dp2[j],min(dp2[j-1],dp2[j+1]))
                if j - 1 < 0:
                    dp[j] = matrix[i][j] + min(dp2[j],dp2[j+1])
 
                elif j + 1 >= col:
                    dp[j] = matrix[i][j] + min(dp2[j],dp2[j-1])

            for i in range(0,len(dp)):
                dp2[i] = dp[i]
            
            flag = 1    
        return min(dp)
                    