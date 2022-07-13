# Time Complexity : O(N^2) // We will iterate over N^2 cells in the matrix, and thus O(N^2)
#  Space Complexity : O(N^2) //Similary the recursive call will have O(N), while the 2D matrix memo will use O(N^2). Hence O(N^2) + O(N) = O(N^2)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        m = len(matrix[0])
        
        #Base case if it has oly one element then return that element
        if n == 1:
            return matrix[0][0]
        
        dp = [[float(inf)]*m for _ in range(n)]
        for j in range(m):
            dp[0][j] = matrix[0][j]
        
        #Iterate through row and column to find the smallets possible matrix having a single cell and one by one move towards the remaining matrix
        for i in range (1,n):
            for j in range(m):
                #Initialize pre-computed value and checcking for bounds
                dp[i][j] = matrix[i][j] + dp[i-1][j]
                
                if j-1>=0:
                    dp[i][j] = min((matrix[i][j]+dp[i-1][j-1]),dp[i][j])
                    
                if j+1<m:
                    dp[i][j] = min((matrix[i][j]+dp[i-1][j+1]),dp[i][j])
                    
        return min(dp[n-1])