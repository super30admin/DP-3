# Time Complexity : O(max(nums)+len(nums))
# Space Complexity : O(max(nums))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# We will create of a hashmap of of every number from 0....max(nums) where the value will be number*frequency.
# The DP array will store the maximum summation till now while following the delete and earn rule.

from typing import List
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        freqSum=[0]*(max(nums)+1)
        for n in nums:
            freqSum[n]+=n
        dp=[0]*(len(freqSum))
        dp[0]=freqSum[0]
        dp[1]=freqSum[1]
        for i in range(2,len(freqSum)):
            dp[i]=max(freqSum[i]+dp[i-2],dp[i-1])

        return dp[len(freqSum)-1]