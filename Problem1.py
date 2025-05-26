"""
I implemented referring the solution
Time Complexity: O(n+m)
Space Complexity: O(m)
"""
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0

        max_num = max(nums)
        points = [0] * (max_num + 1)

        # Build the points array
        for num in nums:
            points[num] += num

        # Dynamic programming array
        dp = [0] * (max_num + 1)
        dp[0] = points[0]
        dp[1] = points[1]

        for i in range(2, max_num + 1):
            dp[i] = max(points[i] + dp[i - 2], dp[i - 1])

        return dp[max_num]