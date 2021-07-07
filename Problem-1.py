# Runs on Leetcode
    # Runtime - O(n)
    # Space - O(n) where n is the maximum number in nums


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0 
        
        nums = sorted(nums, reverse=True)
        s = [0 for i in range(nums[0]+1)]
        dp = [0 for i in range(nums[0]+1)]
        for i in nums:
            s[i] += i
            
        dp[0] = 0
        dp[1] = s[1]
        
        for i in range(2, len(dp)):
            dp[i] = max(s[i] + dp[i-2], dp[i-1])
            
        return dp[-1]
