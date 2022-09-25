# passed on leet code
#TC: O(N)+(max value of array)
#SC:O(max value of array)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        import math
        ans = -12527404
        if len(nums)==0:
            return 0
        for i in range(len(nums)):
            ans = max(nums[i],ans)
        
        dp = [0]*(ans+1)

        for i in range(len(nums)):
            val = nums[i]
            dp[val]=dp[val]+val
        print(dp)
        skip =0
        take = dp[0]
        for i in range(ans+1):
            temp = skip
            skip=max(take,skip)
            take = temp+dp[i]
        return max(take,skip)