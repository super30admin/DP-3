#Time Complexity:  O(n + Max), where n is the length of the input array nums and Max is the maximum value in the array.
#Space Complexity: O(Max), as we are creating a DP table of size Max + 1

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0

        Max = 0
        for i in range(len(nums)):
            Max = max(Max, nums[i])

        dp = [0 for i in range(Max+ 1)]
        for i in range(len(nums)):
            dp[nums[i]] = dp[nums[i]] + nums[i]

        skip = 0
        take = dp[0]

        for i in range(1, len(dp)):
            temp = skip
            skip = max(skip, take)
            take = temp + dp[i]

        return max(skip, take)