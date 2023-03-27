# Time Complexity : O(n) Counter (n) + sorted (klogk) + helper (k), but expecting n >> k
# Space Complexity : O(n) Counter (n) + sorted (k) + dp (k)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
This code solves the problem by creating a value in selecting each number, and then recursively
choosing or not choosing the next number. The key is to use a dp to store the max value for each
number, so that we do not have to recalculate the max value for each number.
"""

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        counter = collections.Counter(nums)
        counter = {k: k*v for k, v in counter.items()}

        numbers = list(counter.keys())
        numbers = sorted(numbers)
        dp = collections.defaultdict()

        return self.helper(counter, dp, numbers, 0)

    def helper(self, counter, dp, numbers, index):
        # base
        if index > len(numbers) - 1:
            return 0
        elif index == len(numbers) - 1:
            return counter[numbers[index]]

        if numbers[index] in dp:
            return dp[numbers[index]]

        # case 1- do not pick
        case1 = self.helper(counter, dp, numbers, index + 1)



        #case 2- to pick
        if numbers[index + 1] == numbers[index] + 1:
            case2 = counter[numbers[index]] + self.helper(counter, dp, numbers, index + 2)
        else:
            case2 = counter[numbers[index]] + self.helper(counter, dp, numbers, index + 1)

        dp[numbers[index]] = max(case1, case2)

        return dp[numbers[index]]




