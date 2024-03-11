# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        #Create a frequency array that contains freq of each ele
        freq_array = [0]*(max(nums)+1)
        for num in nums:
            freq_array[num]+=num
        #Now it's converted into house robber problem
        dp = [0]*len(freq_array)
        dp[1] = freq_array[1]
        for i in range(2,len(freq_array)):
            dp[i] = max(dp[i-1],freq_array[i]+dp[i-2])
        return dp[-1]