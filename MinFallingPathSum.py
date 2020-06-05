------------------------------ Recursion ------------------------------------------------

#Time Complexity : O(3**n X number of columns) n is the length of costs  array
# Space Complexity : O(NXM) Number of rows * Cols
# Did this code successfully run on Leetcode : NO
# Any problem you faced while coding this : Yes, Maximum recursion depth exceeded
# 
# Here In this problem, we have 3 paths from each and every element of the array. One if index-1, index and index+1.
#and we can have a base case as row exceeds the length of the array and col exceeds the edges of the array. Once we calculate 
#the sum of the index-1, index and index+1 element we will take the minimum of the 3 paths. We will repeat 
#the same process for all the columns and return the minimum of all the elements.



class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if not A:
            return 0
        m = len(A)
        res = float('inf')
        
        def dfs(A, col,row):
            if row==len(A):
                return 0
            
            if col==0 or col==len(A[0]):
                return 0
            
            ans = float('inf')
            ans = min(ans, dfs(A, row+1, col+1)+A[row][col])
            ans = min(ans, dfs(A, row+1, col-1)+A[row][col])
            ans = min(ans, dfs(A, row+1, col)+A[row][col])
                
            return ans
        
        for j in range(len(A[0])):
            res = min(res,dfs(A, j, 0))
        return res
  
  
  ---------------------- Dynamic Programming ------------------------------------------------   
# Time Complexity : O(MXN) M is the length of array and N is the columns of the Array.
# Space Complexity : O(MXN) dp array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here In this problem, I have created a new array i which I copied the first row of the array. By iterating from the second row, 
#for each element, we can check the paths coming to that particular index and take the minimum of all the indexes+ element at that index.
#So here we can choose col +1, col-1, col elements.

        
class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if not A:
            return 0
        
        m = len(A)
        n = len(A[0])
        dp = [[0]*n for i in range(m)]
        
        dp[0] = A[0]
        
        for i in range(1,m):
            for j in range(n):
                if j == 0:
                    dp[i][j] = min(dp[i-1][j], dp[i-1][j+1])+A[i][j]
                elif j == n-1:
                    dp[i][j] = min(dp[i-1][j], dp[i-1][j-1])+A[i][j]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i-1][j+1])+A[i][j]
        return min(dp[-1])