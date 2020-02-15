class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        max_value = max(nums)
        
        dp = [0 for _ in range(max_value+1)]
        
        for i in range(len(nums)):
            dp[nums[i]] += nums[i]
        
        use, avoid = dp[0], 0
        
        for i in range(1, len(dp)):
            new_use = dp[i] + avoid
            new_avoid = max(avoid, use)
            use, avoid = new_use, new_avoid 
        return max(use, avoid)
