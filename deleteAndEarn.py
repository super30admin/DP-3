# Time complexity : O(n) where n is the number of unique elements in the array
# Space complexity : O(n)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : No, followed the same idea as house robber but this implementation still doesn't handle varied edge cases(works for sequential and non sequential inputs).
# still needs work


import collections


class Solution:
    def deleteAndEarn(self, nums):
        counter = collections.Counter(nums)
        n = len(counter)
        hmap = sorted(counter)

        dp = [[0 for _ in range(2)] for _ in range(n)]

        dp[0][0] = hmap[0]*counter[hmap[0]]
        dp[0][1] = 0

        for i in range(1, n):
            for choice in range(2):
                if choice == 0:
                    if hmap[i] - hmap[i-1] == 1:
                        dp[i][choice] = hmap[i] * counter[hmap[i]] + dp[i-1][1]
                    else:
                        dp[i][choice] = dp[i-1][choice] + \
                            hmap[i]*counter[hmap[i]]

                else:
                    dp[i][choice] = max(dp[i-1][0], dp[i-1][1])
        return max(dp[n-1][0], dp[n-1][1])
