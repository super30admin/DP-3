#TC => o(N + K) k denotes maximum element
#SC => o(N + K)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_ = max(nums)
        
        dp = [0]*(max_+1)
        
        for i in range(len(nums)):
            dp[nums[i]] += nums[i] 
        
        skip = 0
        one = dp[0]
        
        for i in range(len(dp)):
            skip,one = max(skip,one), skip+dp[i]
        return max(skip,one)