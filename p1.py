# Time Complexity : O(n*lgn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:

        d = dict()

        for n in nums:
            if n in d:
                d[n] += 1
            else:
                d[n] = 1

        l = list(d.keys())
        l.sort()

        arr = [[l[i], d[l[i]]] for i in range(len(l))]

        dp = [[0, 0] for i in range(len(arr))]

        dp[0][0] = arr[0][1] * arr[0][0]
        dp[0][1] = 0

        for i in range(1, len(arr)):

            if arr[i][0] == arr[i - 1][0] + 1:
                dp[i][0] = dp[i - 1][1] + arr[i][1] * arr[i][0]
            else:
                dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]) + arr[i][1] * arr[i][0]

            dp[i][1] = max(dp[i - 1][0], dp[i - 1][1])

        return max(dp[-1])
























