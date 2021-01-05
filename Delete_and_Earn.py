# // Time Complexity : O(n) where n is the max(size of the input array, max number in the input)
# // Space Complexity : O(n) where n is the max(size of the input array, max number in the input)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :yes, learnt the optimal approach from sir
    
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if (nums==[] or len(nums)==0):
            return 0
        
        max1=0
        for i in nums:
            max1=max(i,max1)
        max1=max(len(nums),max1)
        
        dp=[0]*(max1+1)
        
        for i in nums:
            dp[i]=dp[i]+i
        
        for i in range(1,len(dp)):
            if(i==1):
                dp[i]=max(dp[i],dp[i-1])
            else:
                dp[i]=max(dp[i]+dp[i-2],dp[i-1])
        return dp[max1]