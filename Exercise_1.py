# Time Complexity : O(n + k log k), where k is the number of unique values.
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : The trick was converting repeated numbers into points and then handling adjacent values like House Robber.
# Approach: I first counted the total points earned by choosing each number.
# Then I processed the sorted unique numbers and decided whether to take or skip each value.
# If two values are adjacent, taking the current value must combine with the best score before the previous value.


class Solution:

    def deleteAndEarn(self, nums):
        if not nums:
            return 0

        points = {}

        for num in nums:
            points[num] = points.get(num, 0) + num

        values = sorted(points)
        avoid = 0
        using = 0
        previous = None

        for value in values:
            best_before = max(avoid, using)

            if previous is not None and value == previous + 1:
                current_using = avoid + points[value]
            else:
                current_using = best_before + points[value]

            avoid = best_before
            using = current_using
            previous = value

        return max(avoid, using)
