# Time Complexity: O(n + m) where m is the maximum number in array of length n
# Space Complexity: O(m)

# The code ran successfully on Leetcode

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0 or nums == None: 
            return 0
    
        maximum = -math.inf
        
        for i in  range(len(nums)):
            maximum = max(nums[i], maximum)
        
        dp = [0 for i in range(maximum + 1)]
        
        for i in range(len(nums)):
            idx = nums[i]
            dp[idx] += idx
            
        skip = 0
        take = dp[0]
        
        for i in range(1, maximum + 1):
            temp = skip
            skip = max(take, skip)
            take = temp + dp[i]
            
        return max(skip, take)
            
        
        
        