#Time Complexity-T(n^2)
#Space Complexity-O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Yes, logic behind to add minimum number from above list

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        
        n= len(A) #O(1)
        m= len(A[0]) #O(1)
        dp = [[0]*m for _ in range(n)] #O(m) m-size of list-constant
        dp[0] = A[0]
        for i in range(1, n): #T(n) n-size of the list
            for j in range(m): #T(n)
                dp[i][j] = A[i][j] + min(dp[i-1][max(j-1,0)], dp[i-1][j], dp[i-1][min(j+1, m-1)]) #O(1) 
                
        return min(dp[n-1]) #O(1)