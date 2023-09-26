#Time Complexity: O(N + Max)
#Space Complexity: O(Max)
#where N is the length of the input list nums, and Max is the maximum value in nums
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        Max = 0
        for i in range(len(nums)):
            Max = max(Max, nums[i])

        dp = [0 for i in range(Max + 1)]  # Initialize a DP array

        for i in range(len(nums)):
            idx = nums[i]
            dp[idx] += nums[i]  # Accumulate values in the DP array

        skip = 0
        take = dp[0]

        for i in range(1, Max + 1):
            temp = skip
            skip = max(skip, take)
            take = temp + dp[i]

        return max(skip, take)
