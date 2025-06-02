# Implementation : Transform the problem into a House Robber–style DP on the sum of points for each number.
# Time Complexity: O(n + k), where n = len(nums) and k = max(nums), since we build the points array and run DP up to the maximum number.
# Space Complexity: O(k), due to the points dictionary/array and the DP array of size (max_number + 1).

from collections import defaultdict
from typing import List

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        """
        Returns the maximum points you can earn by choosing numbers such that
        picking num removes all instances of num-1 and num+1.
        """
        points = defaultdict(int)
        max_number = 0
        for num in nums:
            points[num] += num
            max_number = max(max_number, num)
        
        max_points = [0] * (max_number + 1)
        if max_number >= 1:
            max_points[1] = points[1]

        for num in range(2, max_number + 1):
            max_points[num] = max(max_points[num - 1], max_points[num - 2] + points[num])

        return max_points[max_number]
