# TC = O(n)
# SC = O(n)
# Where n is maximum number in nums array
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxelement = 0

        for i in range(len(nums)):
            maxelement = max(maxelement, nums[i])

        sumarray = [0] * (maxelement + 1)

        for i in range(len(nums)):
            sumarray[nums[i]] += nums[i]
        print(sumarray)

        dp = [0] * (maxelement + 1)
        dp[0] = sumarray[0]
        dp[1] = max(sumarray[1], sumarray[0])
        for i in range(2, maxelement + 1):
            dp[i] = max(dp[i - 1], sumarray[i] + dp[i - 2])
        print(dp)
        return dp[maxelement]
