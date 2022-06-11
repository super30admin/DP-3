class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        '''// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach'''
        
        if len(nums)==0:
            return 0
            
        if len(nums)==1:
            return nums[0]
        
        #Reducing the array into house robber pattern
        
        maxlen=max(nums)
        
        dp=[0]*(maxlen+1)
        
        for num in nums:
            dp[num]+=num

        #Solving according to the house robber pattern
        dp[0]=dp[0]
        dp[1]=max(dp[0],dp[1])
        
        for i in range(2,len(dp)):
            dp[i]=max(dp[i-1], dp[i]+dp[i-2])
        
        
        return dp[maxlen]
