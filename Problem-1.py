# Delete and Earn
'''
Leetcode all test cases passed: Yes
Solution:
    deleteAndEarn(self, nums):
        n is length of nums
        Space Complexity: O(max(n))
        Time Complexity: O(n + max(n))
'''
class Solution:
    def houseRobber(self,nums):
        rob = 0
        do_not_rob = 0

        for num in nums:
            temp = do_not_rob
            do_not_rob = max(rob,do_not_rob)
            rob = max(num + temp, rob)

        return max(rob,do_not_rob)

    def deleteAndEarn(self, nums):
        maximum_value = max(nums)
        dp = [0] * (maximum_value + 1)
        for num in nums:
            dp[num] += num
        return self.houseRobber(dp)
