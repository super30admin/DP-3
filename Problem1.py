# DP-3

## Problem1: (https://leetcode.com/problems/delete-and-earn/)


#Time Complexity : O(n)
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        value1=[0]*(max(nums)+1)
        dp=[[0,0] for i in range(len(value1))]
        for num in nums:
            value1[num]+=num
        
        for i in range(1,len(dp)):
            dp[i][0]=max(dp[i-1][0],dp[i-1][1])
            dp[i][1]=value1[i]+dp[i-1][0]
        return max(dp[-1])
        