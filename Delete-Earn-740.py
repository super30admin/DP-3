# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        mx = max(nums)
        arr = [0] * (mx+1)
        for i in range(0, len(nums)):  #Create Counter array to populate the nums array for handling nums[i-1] and nums[i+1]
            arr[nums[i]] += nums[i]
        
        # Similar to house robber now
        dp = [0] * len(arr)
        dp[0] = arr[0]
        dp[1] = max(arr[0], arr[1])
        
        for i in range(2, len(arr)):
            dp[i] = max(dp[i-2] + arr[i], dp[i-1])
        return dp[-1]
