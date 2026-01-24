"""
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
"""


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        dpSize = max(nums)
        arr = [0 for i in range(dpSize+1)]
        for num in nums:
            arr[num] += num
        dp = [0 for i in range(dpSize+1)]
        prev = arr[0]
        cur = arr[1]
        for i in range(2,dpSize+1):
            temp = cur
            cur = max(cur,arr[i]+prev)
            prev = temp
        return cur
