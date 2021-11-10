"""
House-Robber Pattern

Time Complexity: O(max(nums))
Space Complexity: O(max(nums))
"""


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # order matters, so remove that obstacle --> earning on removing a value
        hashMap = {}
        for i in range(max(nums) + 1):
            if i not in hashMap:
                hashMap[i] = 0

        for i in range(len(nums)):
            hashMap[nums[i]] += nums[i]

        # skip and take
        dp_array = [[None] * 2 for _ in range(max(nums) + 1)]
        # skip
        dp_array[0][0] = 0
        # earn
        dp_array[0][1] = 0

        for i in range(1, max(nums) + 1):
            # skip
            dp_array[i][0] = max(dp_array[i - 1][0], dp_array[i - 1][1])
            # take
            dp_array[i][1] = dp_array[i - 1][0] + hashMap[i]

        return max(dp_array[max(nums)][0], dp_array[max(nums)][1])



