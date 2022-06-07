#TC: O(n)+O(max(nums)) where n is elements in nums and nums is array given
#SC:O(1)
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        m=max(nums)
        dp=[0 for i in range(m+1)]
        for i in range(0,len(nums)):
            dp[nums[i]]+=nums[i]
        
        if len(dp)==0 : return 0
        if len(dp)==1 : return dp[-1]
        else:
            if dp[1]<dp[0]:
                dp[1]=dp[0]
           
            for i in range(2,len(dp)):
                if dp[i]+dp[i-2]>dp[i-1]:
                    dp[i]+=dp[i-2]
                else:
                    dp[i]=dp[i-1]
            return dp[-1]