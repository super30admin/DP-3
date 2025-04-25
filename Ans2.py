# Time Complexity :  O(m * n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes      
# Any problem you faced while coding this : No  

# Your code here along with comments explaining your approach: In this case we have repeated subproblems so we use DP to solve the problem. We create an array named dp and we store the last row values. Now we traverse all the columns and store the min value for that particular index in the dp array. At the end we return the minimum value from that particular index.  

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        dp = [0] * n

        for j in range(0, n):
            dp[j] = matrix[n - 1][j]
        
        for i in range(n - 2, -1, -1):
            left = 0
            for j in range(n):
                temp = dp[j]
                if j == 0:
                    dp[j] = matrix[i][j] + min(dp[j],dp[j+1]) 
                
                elif j == n - 1:
                    dp[j] = matrix[i][j] + min(dp[j], left)

                else:
                    dp[j] = matrix[i][j] + min(dp[j], min(left, dp[j + 1]))
                
                left = temp
            
        minVal = float("inf")
        for j in range(n):
            if minVal > dp[j]:
                minVal = dp[j]
        
        return minVal