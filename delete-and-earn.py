#TC: O(max(n, max_element))
#SC: O(max_element)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        dp=[0]*(max(nums)+1)
        for num in nums:    dp[num]+=num
        dp[1]=max(dp[0],dp[1])
        for i in range(2,len(dp)):
            dp[i]=max(dp[i-1],dp[i]+dp[i-2])
        return dp[-1]