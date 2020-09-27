"""
Problem: Delete and Earn
Leetcode: https://leetcode.com/problems/delete-and-earn/
Solution: Dynamic Programming
Example:
        Input: nums = [3, 4, 2]
        Output: 6
Time Complexity: O(n+m), where n = len(nums) and m = range of number in nums
Space Complexity: O(m)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
"""

import collections


class Solution:
    def delete_and_earn(self, nums):
        # Base case
        if nums is None or len(nums) == 0:
            return 0

        dic = collections.defaultdict(int)
        minimum = float('inf')
        maximum = -float('inf')
        for n in nums:
            dic[n] += 1
            maximum = max(maximum, n)
            minimum = min(minimum, n)
        prev = 0
        curr = 0
        for i in range(minimum, maximum + 1):
            prev, curr = curr, max(prev + dic[i] * i, curr)
        return curr


obj = Solution()
print(obj.delete_and_earn([3, 4, 2]))
print(obj.delete_and_earn([2, 2, 3, 3, 3, 4]))
