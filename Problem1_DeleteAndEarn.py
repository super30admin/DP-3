# Time Complexity: O(max(n,M)) where n - length of input array, M - max element of the array
# Space Complexity: O(M), where M - max element of the array
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

# Solution:

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0:
            return 0

        # Array to store the total sum of every number
        mnums = [0] * (max(nums) + 1)
        for num in nums:
            mnums[num] += num

        skip, take = 0, mnums[0]

        # Compute the total points for 2 cases - skip & take for every number

        for i in range(1, len(mnums)):
            # skip
            temp = skip
            skip = max(skip, take)
            # take
            take = temp + mnums[i]

        return max(skip, take)