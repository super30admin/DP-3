"""
https://leetcode.com/problems/delete-and-earn/

Approach --
- Use a max variable inorder to find maxval to create a DP array
- Once DP array is formed, the pattern is similar to HouseRobber problem
- Now, either skip or take, like HouseRobber

TC - O(n)
SC - O(n)
"""
import sys

n = [3, 4, 2]


def deleteEarn(nums):
    if len(nums) == 0 or nums is None: return 0

    maxVal = -sys.maxsize - 1
    for i in range(len(nums)):
        maxVal = max(maxVal, nums[i])

    # here dp array is [0,0,2,3,4]
    dp = [0 for i in range(maxVal + 1)]

    for i in range(len(nums)):
        dp[nums[i]] += nums[i]

    skip = 0
    take = dp[0]

    for i in range(1, maxVal + 1):
        temp = skip
        skip = max(skip, take)
        take = temp + dp[i]

    return max(skip, take)

print(deleteEarn(n))
