# Time Complexity : O(max(n, max_num)), where n is the size of the array and max_num is the largest element in the array
# Space Complexity : O(max_num)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_num = max(nums)

        new_nums = [0 for i in range(max_num + 1)]

        # create a new array from the input array to act as input to the house robber's problem
        for i, num in enumerate(nums):
            new_nums[num] += num

        skip = 0
        take = new_nums[0]

        for i in range(1, len(new_nums)):
            temp_skip = skip
            skip = max(skip, take)
            take = temp_skip + new_nums[i]

        return max(skip, take)
