"""
Time Complexity : O(n+m) where n is the length of the nums and m is the maxElement in the nums
Space Complexity : O(maxEle) This required to store sum of the numbers in the nums
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0

        # Step1: Find the maximum element
        maxEle = nums[0]
        for num in nums:
            maxEle = max(maxEle, num)

        # Step2: Find the sum of all the numbers
        dp = [0] * (maxEle + 1)
        for num in nums:
            dp[num] += num

        # Step3:
        """
        Now the problem is converted into choose and not choose.
        Choosing the number means cannot choose the previous number, so earning will be the currNum + dp[i-2]
        Not choose case means we can choose the previous number, so earning for the currnumber will be max(choose, notChoose)
        """
        dp[1] = max(dp[0], dp[1])
        for i in range(2, len(dp)):
            dp[i] = max(dp[i-1], dp[i-2]+dp[i])

        return dp[maxEle]
