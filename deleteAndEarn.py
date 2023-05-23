class Solution:
    def deleteAndEarn(self, nums: list[int]) -> int:
        if nums == None and len(nums) == 0:
            return -1
        
        Max = 0
        for i in range(len(nums)):
            Max = max(Max, nums[i])
        
        dp = [0 for i in range(Max+1)]
        
        for i in range(len(nums)):
           
            dp[nums[i]] = dp[nums[i]] + nums[i]
            
        skip = 0
        take = dp[0]
        
        for i in range(len(dp)):    
            temp = skip
            skip = max(skip,take)
            take = temp + dp[i]
        
        return max(skip,take)
    
    
#time complexity ---> O(max)  where max is the maximum element in the array
#space complexity --> O(max)