# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach

# with-out mutating the dp array and using constant space
class Solution:
    def deleteAndEarn(self, nums: list[int]) -> int:
        dp = [0] * (max(nums) + 1)
        for i in nums:
            dp[i] += i
        temp0 = dp[0]
        temp1 = dp[1]
        for i in range(2, len(dp)):
            temp0, temp1 = temp1, max(temp1, dp[i] + temp0)
        return temp1


check = Solution()
print(check.deleteAndEarn([3, 4, 3]))

# mutating the dp array. TC - O(n), SC - O(n)
# class Solution:
#     def deleteAndEarn(self, nums: list[int]) -> int:
#         dp = [0] * (max(nums) + 1)
#         for i in nums:
#             dp[i] += i
#         for i in range(len(dp)):
#             if i == 1:
#                 dp[i] = max(dp[i], dp[i-1])
#             if i > 1:
#                 dp[i] = max(dp[i-1], dp[i] + dp[i-2])
#         return dp[len(dp)-1]
# #
#
# check = Solution()
# print(check.deleteAndEarn([3, 4, 3]))

# mutating the dp array
# class Solution:
#     def deleteAndEarn(self, nums: list[int]) -> int:
#         dp = [0] * (max(nums) + 1)
#         for i in nums:
#             dp[i] += i
#         for i in range(len(dp)-1, -1, -1):
#             if i == len(dp)-3:
#                 dp[i] = dp[i] + dp[i+2]
#             elif i < len(dp)-3:
#                 dp[i] += max(dp[i+2], dp[i+3])
#         return max(dp[0], dp[1])
#
#
# check = Solution()
# print(check.deleteAndEarn([3, 4, 3]))


# Recursive approach - Time limit Exceeded.
# class Solution:
#     def helper(self, temp, index, sum):
#         if index > len(temp) - 1:
#             return sum
#         case1 = self.helper(temp, index + 1, sum)
#         case2 = self.helper(temp, index + 2, sum + temp[index])
#         return max(case1, case2)
#
#     def deleteAndEarn(self, nums: list[int]) -> int:
#         temp = [0] * (max(nums) + 1)
#         for i in nums:
#             temp[i] += i
#         return self.helper(temp, 0, 0)
#
#
# check = Solution()
# print(check.deleteAndEarn([3, 4, 3]))
