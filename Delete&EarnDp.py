"""
Time Complexity : O(n) + O(max element) 
Space Complexity : O(max element)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        maxi = 0
        # Finding the maximum element from the array
        for num in nums:
            maxi = max(maxi, num)
        dp = [0] * (maxi + 1)
        # Setting my array to the value of the possible deletion values
        for num in nums:
            dp[num] += num
        skip = 0 
        take = dp[0]
        # Making my dp matrix through skip and take variables to 
        # optimize complexity
        for i in range( 1, len(dp)):
            temp = skip
            skip = max(skip, take)
            take = temp + dp[i]
        return max(skip, take)