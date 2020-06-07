# Time Complexity : O(n^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def minFallingPathSum(self,A): 
        row,col = len(A), len(A[0])
        dp = [0] * (col+2)
        for i in range(1,row+1):
            dp[0],dp[col+1] = dp[1],dp[col]
            row = dp.copy()
            print("row",row)
            for j in range(1,col+1):
                row[j] = A[i-1][j-1] + min(dp[j-1], dp[j], dp[j+1])
            dp = row 
            print("dp",dp)
        return min(dp[1:col+1])

if __name__ == "__main__":
    s = Solution()
    A = [[1,2,3],[4,5,6],[7,8,9]]
    res = s.minFallingPathSum(A)
    print(res)