#Time Complexity : O(N) numbe rof inouts +Max (of the input) or length of DP array
#Space Complexity : O(m) where m is maximum value of the input which is used for the creating of DP array

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        a = [0]*(max(nums)+1)
        for i in range (len(nums)):
            a[nums[i]] = a[nums[i]] + nums[i]
        dp = [[0 for x in range (2)] for y in range(len(a))]
        
        for i in range (len(a)):
            dp[i][0] = max(dp[i-1][1],dp[i-1][0])
            dp[i][1] = dp[i-1][0] + a[i]
        print(dp)
        result = max(dp[len(dp)-1][0],dp[len(dp)-1][1])
        return result
            