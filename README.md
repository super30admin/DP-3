# DP-3

## Problem1: (https://leetcode.com/problems/delete-and-earn/)
#Time Complexity=O(maximum number)
#Space Complexity=O(maximum number)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        h={}
        a=max(nums)
        for i in nums:
            if i in h:
                h[i]+=i
            else:    
                h[i]=i
        for i in range(a+1):
            if i not in h:
                h[i]=0
        b=[[0]*2 for _ in range(a+1)]
        
        for i in range(1,a+1):
            b[i][0]=max(b[i-1][0],b[i-1][1])
            b[i][1]=b[i-1][0]+h[i]
        return max(b[a][0],b[a][1])
        


## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)


#Time Complexity=O(rows*columns)
#Space Complexity=O(rows*columns)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        row = len(matrix)
        col = len(matrix[0])
        dp = [[0 for j in range(col) ] for i in range(row)]
        i = row - 1
        j = col - 1
        while j != -1:
            dp[i][j] = matrix[i][j]
            j -= 1
        for i in range(row-2,-1 ,-1):
          
            for j in range(col-1 , -1 , -1):
                if j == col - 1:
                    dp[i][j] = min(matrix[i][j] + dp[i+1][j] , matrix[i][j] + dp[i+1][j-1] )
              
                elif j == 0:
                    dp[i][j] = min(matrix[i][j] + dp[i+1][j] , matrix[i][j] + dp[i+1][j+1] )
               
                else:
                    dp[i][j] = min(matrix[i][j] + dp[i+1][j] , matrix[i][j] + dp[i+1][j-1] ,matrix[i][j] + dp[i+1][j+1])
                    
        return min(dp[0])