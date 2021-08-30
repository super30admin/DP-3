# Time COmplexity : O(n)
# Space Complexity : O(1)
# Is this problem on the leetcode: Yes
# Approach to solve the problem:
# Given an array nums of integers, you can perform operations on the array.
#
# In each operation, you pick any nums[i] and delete it to earn nums[i] points.
# After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
#
# You start with 0 points.
# Return the maximum number of points you can earn by applying such operations.

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        vals = [0] * 10001
        for num in nums:
            vals[num] += num
        val_i, val_i_1 = vals[0], 0
        for i in range(1, len(vals)):
            val_i_1, val_i_2 = val_i, val_i_1
            val_i = max(vals[i] + val_i_2, val_i_1)
        return val_i
