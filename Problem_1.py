# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        val = ([0] * 10001)
        for num in nums:
            val[num] += num
        val1, val11 = (val[0], 0)
        for i in xrange(1, len(val)):
            val11, val22 = val1, val11
            val1 = max(val[i] + val22, val11)
        return val1