class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        lis=[0 for i in range(0,max(nums)+1)]

        for i in range(0,len(nums)):
            lis[nums[i]]+=nums[i]
        
        dp=[0 for i in range(0,len(lis))]
        dp[0]=lis[0]
        dp[1]=max(lis[0],lis[1])

        for i in range(2,len(lis)):
            dp[i]=max(dp[i-1],lis[i]+dp[i-2])
        
        return dp[-1]

        