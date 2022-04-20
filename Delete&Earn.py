# // Time Complexity : O(max(nlogn), max value in nums array) - doubtful
# // Space Complexity : O(m) =>m is the max value in nums array - doubtful
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        size = len(nums)

        nums.sort()

        max_value = nums[size - 1]

        earnings = [0] * (max_value + 1)

        for num in nums:
            earnings[num] = earnings[num] + num

        skip = 0
        take = 0

        for i in range(max_value+1):
            number = earnings[i]
            temp = skip

            skip = max(skip, take)
            take = temp + earnings[i]

        return max(skip, take)
