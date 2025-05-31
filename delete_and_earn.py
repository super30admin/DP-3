#Time Complexity: O(N logN)
#Space Complexity: O(N)

from collections import Counter

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0

        count = Counter(nums)
        unique = sorted(count.keys())
        points = [num * count[num] for num in unique]
        n = len(unique)
        memo = [-1] * n

        def helper(i):
            if i < 0:
                return 0
            if i == 0:
                return points[0]
            if memo[i] != -1:
                return memo[i]

            if unique[i] == unique[i - 1] + 1:
                take = points[i] + helper(i - 2)
            else:
                take = points[i] + helper(i - 1)

            skip = helper(i - 1)
            memo[i] = max(take, skip)
            return memo[i]

        return helper(n - 1)