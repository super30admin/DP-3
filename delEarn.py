# Time Complexity : O(n + k) where n = len(nums) and k = max(nums)
# Space Complexity : O(k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# First aggregate points for each number 
# If we pick value i, we cannot pick i+1, so the choice becomes:
# pick = arr[i] + dp[i+2]
# skip = dp[i+1]
# Build dp from right to left and store the maximum points obtainable.
# Final answer is dp[0].


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        get_max = max(nums)
        arr = [0] * (get_max + 1)
        for n in nums:
            arr[n] += n
        dp = [0] * (get_max + 3)
        for i in range(get_max, -1, -1):
            dp[i] = max(arr[i] + dp[i + 2], dp[i + 1])
        return dp[0]