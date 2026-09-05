# Problem1: (https://leetcode.com/problems/delete-and-earn/)
# TC: O(n + max(nums)),building max_val and arr takes O(n), building dp takes O(max(nums))
# SC: O(max(nums)),arr and dp are both sized max_val + 1
# Approach:
# Group values into buckets where arr[i] holds total points from taking all of number i.
# Taking number i forces us to skip i-1 and i+1, so this becomes the house robber
# problem on the arr list: dp[i] is either skip i (dp[i-1]) or take i (arr[i] + dp[i-2]).

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_val = 0

        # find the largest number in nums so we know how big our bucket array needs to be
        for num in nums:
            max_val = max(max_val, num)
        
        # arr[i] will store total points earned if we fully take number i
        arr = [0] * (max_val + 1)
        for num in nums:
            arr[num] += num  # add this number's value to its own bucket

        # dp[i] = best score achievable using only numbers 0 through i
        dp = [0] * (max_val + 1)
        dp[0] = 0  # base case: nothing meaningful at index 0 by itself
        dp[1] = max(arr[0], arr[1])  # base case: best of first two buckets

        # for each index, either skip it (dp[i-1]) or take it (arr[i] + dp[i-2])
        for i in range(2, max_val + 1):
            dp[i] = max(dp[i-1], arr[i] + dp[i-2])
        
        # dp[max_val] holds the best score considering every number in nums
        return dp[max_val]