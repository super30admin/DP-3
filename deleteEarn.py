# Time Complexity : O(N) where N = len(nums)
# Space Complexity : O(N) where  n = count
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution:
    def deleteAndEarn(self, nums: [int]) -> int:
        # edge case
        if len(nums) == 0 or not nums:
            return 0
        import collections
        count = collections.Counter(nums)
        max_num = max(nums + [0])
        dp = [0] * (max_num + 10)
        for i in range(1, max_num + 1):
            dp[i] = max(dp[i - 1], dp[i - 2] + count[i] * i)  # delete the maximum score of numbers not greater than i
        return dp[max_num]


r = Solution()
nums = [2, 2, 3, 3, 3, 4]
print("Output is ", r.deleteAndEarn(nums))
