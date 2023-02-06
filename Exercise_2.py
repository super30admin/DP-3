#Time Complexity : O(N^2), N being the length of the matrix.
#Space Complexity : O(N^2), N being the length of the matrix.
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Doing the recursive way in the beginning
#got be confused for a bit. Turning it into dp was okay.

#Your code here along with comments explaining your approach in three sentences only
'''Find all cases using recursion, and then save the values into a dp array to use
dynamic programming. Then, find the minimum of the remaining n choices at the top
of the array. 
'''
class Solution:
    def handler(self, matrix, index, i, dp):
        n = len(matrix)
        # to handle the base case. 
        if index+1>=n:
            return matrix[index][i]
        current = matrix[index][i]
        next_below = matrix[index+1][i]

        #if there is a left index, recurse if dp doesn't have value, or take the
        #value from dp array.
        if i-1>=0:
            if dp[index+1][i-1]==None:
                dp[index+1][i-1] = self.handler(matrix, index+1, i-1, dp)
            result_left = current+dp[index+1][i-1]
        #similar for right. 
        if i+1<n:
            if dp[index+1][i+1]==None:
                dp[index+1][i+1] = self.handler(matrix, index+1, i+1, dp)
            result_right = current +dp[index+1][i+1]
        # similar for middle. 
        if dp[index+1][i]==None:
            dp[index+1][i]=self.handler(matrix, index+1, i, dp)
        result_mid = current+dp[index+1][i]
        
        #find minimum of the 3 or less choices. 
        result = result_mid
        if i-1>=0:
            result = min(result, result_left)
        if i+1<n:
            result = min(result, result_right)
        return result
        

    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        #define dp array with None values and the last row of matrix. 
        dp = [[None for i in range(n)] for j in range(n)]
        for i in range(n):
            dp[n-1][i]=matrix[n-1][i]
        #find the last minimum. 
        result = 101*101
        for i in range(n):
            temp = self.handler(matrix, 0, i, dp)
            result = min(result, temp)
        return result