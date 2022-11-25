"""
    Problem Statement: Delete and Earn

    Time complexity: O(n) (where n is max element in the input)

    Space complexity: O(n) (where n is max element in the input)

    Accepted on LeetCode? Yes! 

    LeetCode Link: https://leetcode.com/problems/delete-and-earn/
"""

from typing import List

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        dp = [0 for i in range(max(nums) + 1)]
        
        for i in range(len(nums)):
            dp[nums[i]] += nums[i]
        
        skip, take = 0, 0
        for i in range(len(dp)):
            temp = skip
            skip = max(skip, take)
            take = temp + dp[i]

        return max(skip, take)

if __name__ == "__main__":
    sol = Solution()
    nums = [2,2,3,3,3,4]
    ret = sol.deleteAndEarn(nums)

    assert ret == 9