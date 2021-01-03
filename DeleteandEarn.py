# Time Complexity : O(N) bucket sort is O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach
# Used Hashmap to get the sum and sorted sum using bucket sort and dynamic programming to get the max points


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        dict = {}
        for i in range(len(nums)):
            if nums[i] not in dict:
                dict[nums[i]] = nums[i]
            else:
                dict[nums[i]] += nums[i]
        buckets = [0] * 10001
        for key, val in dict.items():
            buckets[key] = val
        dp = [0] * (len(buckets) + 1)
        dp[0] = 0
        dp[1] = buckets[0]
        for i in range(1, len(buckets)):
            dp[i + 1] = max(dp[i], buckets[i] + dp[i - 1])

        return dp[len(buckets) - 1]
