class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        #condition to check empty array
        if nums==None or len(nums)==0:
            return 0
        #getting the maximum from given array
        maximum=max(nums)
        #creating an array of aggregates for all existing values
        earned=[0 for i in range(maximum+1)]
        for i in nums:
            earned[i]+=i
        #initializing dp
        dp=[[0 for i in range(2)] for j in range(maximum+1)]
        #updating dp values from earned array
        for i in range(1,maximum+1):
            dp[i][0]=max(dp[i-1][0],dp[i-1][1])
            dp[i][1]=dp[i-1][0]+earned[i]
        return(max(dp[maximum]))
        