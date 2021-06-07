# Delete and Earn
#   Time Complexity : O(n log n)
#   Space Complexity : O(n)
#   Did this code successfully run on Leetcode : No, time limit exceeded
#   Any problem you faced while coding this : No

# Delete and Earn problem can be resolved to House robber problem where each point is summed and the alternate points are ignored
# to find the maximum points that can be earned.

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        dic = collections.Counter(nums)
        keys = sorted(dic.keys())
        prev = 0
        curr = keys[0]*dic[keys[0]]
        for i in range(1, len(keys)):
            if keys[i] - keys[i-1] == 1:
                prev, curr = curr, max(prev + keys[i] * dic[keys[i]], curr)
            else:
                prev, curr = curr, curr + keys[i] * dic[keys[i]]
        return curr