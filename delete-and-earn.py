# Time Complexity : O(n + max(numbers))
# Space Complexity : O(max(numbers))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        # similar to that of house robber problem
        # but here we need to first calculate the maximum number of points

        max_value = -1
        for i in nums:
            max_value = max(max_value, i)

        dp = [0]*(max_value+1)

        for i in nums:
            dp[i] += i

        skip = take = temp = 0

        for i in range(1, len(dp)):
            temp = skip
            skip = max(skip, take) #chosing the max value from skip and take
            take = dp[i] + temp #adding the previous skip and taken elements

        return max(skip, take)
