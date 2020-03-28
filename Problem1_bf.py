#
# Time complexity = O(2^n) where n is size of nums
# Space complexity = O(n)
# TLE on leetcode
#

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        nums.sort()

        def helper(index, val):
            if index == len(nums):
                return val
            else:
                #take
                el = nums[index]
                i = index
                new_val = 0
                maxv = 0
                while(i < len(nums) and nums[i] == el):
                    new_val += el
                    i += 1
                not_take_index = i
                while(i < len(nums) and nums[i] == el+1):
                    i += 1
                maxv = max(maxv, helper(i, val+new_val))

                #skip
                maxv = max(maxv, helper(not_take_index, val))
                return maxv
        return helper(0, 0)
