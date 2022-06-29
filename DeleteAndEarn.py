# Time Complexity : O(m+n) where m is the max num in our first loop and n is the length of max_points
# Space Complexity : O(m+n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        points = defaultdict(int)
        max_number = 0
        # Precomputation, takes O(m)
        for num in nums:
            points[num] += num
            max_number = max(max_number, num)

        max_points = [0] * (max_number + 1)
        max_points[1] = points[1]

        # O(n)
        for num in range(2, len(max_points)):
            max_points[num] = max(max_points[num - 1], max_points[num - 2] + points[num])

        return max_points[max_number]
