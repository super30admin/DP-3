class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        maxv = 0
        for i in range(0,len(nums)):
            maxv = max(nums[i],maxv)
        val = [0 for i in range(maxv+1)]
        dp = [0 for i in range(maxv+1)]

        for i in nums:
            val[i] += 1
        print(val)

        for i in range(1,len(dp)):

            if i > 1:
                dp[i] = max(dp[i-1],dp[i-2]+ val[i] * i)
            else:
               dp[i] = max(dp[i-1],0+ val[i] * i) 
        
        return dp[len(dp)-1]

