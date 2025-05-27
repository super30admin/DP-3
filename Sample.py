# Problem 1: Delete and Earn
# Similar to house robber problem but use frequency array (multiply count with value, not just count).
# Time Complexity : O(n) + O(max(n))
# Space Complexity : O(max(n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums)==1:
            return nums[0]
        me=max(nums)
        arr=[0]*(me+1)
        for i in nums:
            arr[i]+=i
        arr[1]=max(arr[0], arr[1])
        for i in range(2, len(arr)):
            arr[i]=max(arr[i-1], arr[i]+arr[i-2])
        
        return arr[-1]

        


# Problem 2: Min Falling Path Sum
# Similar to paint house problem but here its n choices per each house istead of just 3,so maintain an array
# Time Complexity : O(N^2)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        dp=matrix[0]
        n=len(dp)
        for i in range(1,n):
            temp=dp[:]
            for j in range(n):
                if j==0:
                    if j+1<=n-1:
                        dp[j]=matrix[i][j]+ min(temp[j], temp[j+1])
                    
                elif j==n-1:
                    if j-1>=0:
                        dp[j]= matrix[i][j]+ min(temp[j],temp[j-1])
                
                else:
                    dp[j]= matrix[i][j]+ min(temp[j], temp[j-1], temp[j+1])
        
        return min(dp)
        



