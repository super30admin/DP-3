#Time Complexity : O(N)
#Space Complexity : O(N)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:

        max_number = max(nums) + 1

        dp = [0] * max_number 

        for i in range(len(nums)):

            dp[nums[i]] = dp[nums[i]] + nums[i]
        
        skip = 0
        take = dp[0]

        for i in range(max_number):
            temp = skip
            skip  = max(skip , take)
            take = temp + dp[i]
        

        return max(skip , take)
