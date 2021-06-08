#Convert to house robber using a frequency array
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0
        
        count = [0]*(max(nums)+1)

        for num in nums:
            count[num] += num
        
        #house robber
        if not count:
            return 0
        if len(count) == 1:
            return count[0]
        if len(count) == 2:
            return max(count[0], count[1])
        dp = [0 for _ in range(len(count))]
        dp[0] = count[0]
        dp[1] = max(count[0], count[1])
        for i in range(len(dp)):
            dp[i] = max(dp[i-1],dp[i-2] + count[i])
        return dp[-1]
        
        
        
            