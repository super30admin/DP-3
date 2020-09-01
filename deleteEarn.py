"""
# Given a square array of integers A, we want the minimum sum of a falling path through A.

Time = O(n); n = number of elements in array
space = O(n(, to create dp array
Successfully excecuted on leetcode

Approach - 
store the frequency of each number, the problem converetd to house robber problem now.
 Here, order doesn't mater, so create array to store the frequency of each num
 1. For every house i, there are two options: either to delete-earn it  or not delete-earn it 
 2. We can take maximum amount of values[i]dp[i-2] result or dp[i-1]
"""

class DeleteEarn:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if  not nums:
                return 0

        values = [0] * (max(nums)+1)
        for n in nums:
            values[n] += n

        dp = [0] * len(values)
        dp[1] = values[1]
        for i in range(2, len(values)):
            dp[i] = max(values[i] + dp[i-2], dp[i-1])

        return dp[len(values)-1]