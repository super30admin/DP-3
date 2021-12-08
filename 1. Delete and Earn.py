# Similar to House Robber Problem
class Solution:
    def deleteAndEarn(self, nums) -> int:
        # Time Complexity - O(max(n, max_element))
        # Space Complexity - O(max_element)

        # Find the max element in the array
        max_ = max(nums)
        # Create an array of size of the max element + 1
        dp = [0] * (max_ + 1)

        # Initialize values in dp array
        for num in nums:
            dp[num] += num

        skip = 0
        take = dp[0]

        for i in range(max_ + 1):
            temp = skip
            skip = max(skip, take)
            take = temp + dp[i]

        # Return the max of skip and take
        return max(skip, take)