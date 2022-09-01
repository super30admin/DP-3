#Time Complexity: O(n),
#Space Complexity: O(n)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        sumArray = [0]*(max(nums)+1)
        for i in range(0,len(nums)):
            sumArray[nums[i]] += nums[i]
        dp = [0]*len(sumArray)
        dp[1] = sumArray[1]
        for i in range(2,len(sumArray)):
            dp[i] = max(dp[i-1],dp[i-2]+sumArray[i])
        return dp[-1]