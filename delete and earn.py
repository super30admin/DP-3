# TC-O(max(nums))
# SC-O(max(nums))
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        m=max(nums)+1
        lis=[0]*m
        for i in range(len(nums)):
            lis[nums[i]]+=nums[i]
        dp=[[0 for i in range(2)]for j in range(m)]
        for i in range(1,m):
            dp[i][0]=dp[i-1][1]+lis[i]
            dp[i][1]=max(dp[i-1][0],dp[i-1][1])
        return max(dp[m-1][0],dp[m-1][1])
