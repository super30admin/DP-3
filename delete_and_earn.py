# Delete and earn
# time complexity: O(N + M)
# space complexity: O(N)
# Did this code successfully run on Leetcode : NA
# Any problem you faced while coding this : NA
class Solution:
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
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
        for i in range(minimum, maximum+1):
            prev, curr = curr, max(prev + dic[i]*i, curr)
        return curr