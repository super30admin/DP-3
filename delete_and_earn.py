"""
time 0(n)
space o(n)

we first record all the elements in the array and store them in a dict with it
as key and its freq*value (total points) as value
We also record the smallest and largest value
we then create a 2d array where each row has two elements one to store the total points
for not choosing the current element (which means max of the previous element's row)
and one to store the sum of current element's value along with the value for abandoning
previous element
The final row of the dp will contain the max points
"""

from typing import List


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        min_val = float("inf")
        max_val = float("-inf")
        values = {}
        for i in range(len(nums)):
            if nums[i] not in values:
                values[nums[i]] = nums[i]
                min_val = min(min_val, nums[i])
                max_val = max(max_val, nums[i])
            else:
                values[nums[i]] += nums[i]
        dp = [[0] * 2 for _ in range(min_val, max_val + 1)]
        dp[0][1] = values[min_val]
        for i in range(min_val + 1, max_val + 1):
            not_choose = max(dp[i - min_val - 1])
            choose = values.get(i, 0) + dp[i - min_val - 1][0]
            dp[i - min_val][0] = not_choose
            dp[i - min_val][1] = choose

        return max(dp[-1])
