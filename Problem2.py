# Time Complexity : O(n^2) where n is the number of rows and n is the number of columns 
# Space Complexity : O(n) is size of the elements in the matrix 
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : Yes it is difficult ot create a 2D array in python


# Your code here along with comments explaining your approach : - Similar approach of creation of matrix where the size of matrix is the number of elements in the matrix and here we calculate the minimum of diagonal below and add to above element


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        dp = matrix
        
        for i in range(n-2,-1,-1):
            for j in range(0,n):
                if j==0:
                    dp[i][j] = dp[i][j]+min(dp[i+1][j],dp[i+1][j+1])
                elif j == n-1:
                    dp[i][j] = dp[i][j]+ min(dp[i+1][j],dp[i+1][j-1])
                else:
                    dp[i][j] = dp[i][j]+ min(dp[i+1][j], dp[i+1][j-1],dp[i+1][j+1])
        return min(dp[0])
                    