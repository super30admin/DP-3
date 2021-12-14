# Time Complexity : O(N+M), m is max value  
# Space Complexity :O(M), m is max value

# Did this code successfully run on Leetcode : 
# yes

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approachclass Solution:




import math
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums==None or len(nums)==0 :
            return 0
        maxv = -math.inf 
        for num in nums:
            maxv = max(maxv,num)
        dp=[0]*(maxv+1) 
        for num in nums:
            dp[num] = dp[num]+num
        skip =0
        take = dp[0]
        for  i in range(maxv+1):
            temp = skip
            skip = max(skip,take)
            take = temp+dp[i]
        return max(skip,take)    