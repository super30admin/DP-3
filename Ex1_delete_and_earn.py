# Time Complexity : O(n + m), where n = len(nums), m = max(nums)
# Space Complexity : O(m), for count array of size m + 1
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:

        # space optimization:

        if not nums:
            return 0

        max_num = max(nums)
        count = [0] * (max_num + 1)

        for num in nums:
            count[num] += 1

        prev2 = 0
        prev1 = count[1] * 1

        for i in range(2, max_num + 1):
            curr = max(prev1, prev2 + i * count[i])
            prev2, prev1 = prev1, curr

        return prev1

        # -------------------------------
        # Tabulation (Bottom-up DP)
        # Time: O(n + m), Space: O(m)
        # if not nums:
        #     return 0

        # max_num = max(nums)
        # count = [0] * (max_num + 1)

        # for num in nums:
        #     count[num] += 1
        # dp = [0] * (max_num + 1)
        # dp[0] = 0
        # dp[1] = count[1] * 1
        # for i in range(2, max_num + 1):
        #     dp[i] = max(dp[i - 1], dp[i - 2] + i * count[i])
        # return dp[max_num]

        # -------------------------------
        # Top-down DP with Memoization
        # Time: O(n + m), Space: O(m) for memo and recursion stack
        # memo = [-1] * (max_num + 1)
        # def dfs(i):
        #     if i > max_num:
        #         return 0
        #     if memo[i] != -1:
        #         return memo[i]
        #     take = i * count[i] + dfs(i + 2)
        #     skip = dfs(i + 1)
        #     memo[i] = max(take, skip)
        #     return memo[i]
        # return dfs(0)

        # -------------------------------
        # Naive Recursive (no memo)
        # Time: Exponential, Space: O(m) recursion stack
        # def dfs(i):
        #     if i > max_num:
        #         return 0
        #     take = i * count[i] + dfs(i + 2)
        #     skip = dfs(i + 1)
        #     return max(take, skip)
        # return dfs(0)


if __name__ == "__main__":
    sol = Solution()
    print(sol.deleteAndEarn([3, 4, 2]))              # Output: 6
    print(sol.deleteAndEarn([2, 2, 3, 3, 3, 4]))      # Output: 9
    print(sol.deleteAndEarn([1]))                    # Output: 1
    print(sol.deleteAndEarn([1, 1, 1, 2, 4, 5, 5, 5, 6]))  # Output: 18
    print(sol.deleteAndEarn([8, 10, 4, 9, 1, 3, 5, 9, 4, 10]))  # Output: 37
    print(sol.deleteAndEarn([1, 3, 5, 7, 9]))         # Output: 25
    print(sol.deleteAndEarn([]))                     # Output: 0