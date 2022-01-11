"""
// Time Complexity : O(N) + O(Max(N)) : N : numbers in an array
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

"""
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxval = 0
        for i in range(len(nums)):
            maxval = max(maxval, nums[i])
        arr = [0] * (maxval + 1)

        for i in range(len(nums)):
            arr[nums[i]] += nums[i]

        skip = 0
        take = 0
        for i in range(len(arr)):
            temp = skip
            skip = max(skip, take)
            take = temp + arr[i]
        return max(take, skip)