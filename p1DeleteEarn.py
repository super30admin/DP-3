"""
// Time Complexity : O(nlogN), where n = len(nums) and m = range of number in nums
// Space Complexity :O(M)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

"""


class Solution(object):
    def deleteAndEarn(self, nums):
        points, prev, curr = [0] * 10001, 0, 0
        for num in nums:
            points[num] += num
        for value in points:
            prev, curr = curr, max(prev + value, curr)
        return curr