# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        points = collections.Counter(nums)
        dp = [-1 for _ in range(max(nums)+1)]

        def max_points(num):
            # Check for base cases
            if num == 0:
                return 0
            if num == 1:
                return points[1]
            if dp[num] != -1:
                return dp[num]
            # Apply recurrence relation
            dp[num] = max(max_points(num - 1), max_points(num - 2) + num*points[num])
            return dp[num]

        return max_points(max(nums))