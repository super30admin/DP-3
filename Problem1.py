class Solution:
    def deleteAndEarn(self, nums):
        dp = [0 for i in range(max(nums) + 1)]

        for i in nums:
            dp[i] = dp[i] + i

        DC, C = 0, 0
        for i in dp:
            temp = DC
            DC = max(C, DC)
            C = temp + i

        return max(C, DC)



#TC:O(max(len(nums),max(nums)))
#SC:O(max(nums))