#Time Complexity: 0(n)
#Space Compleixty: O(n)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxele = max(nums)
        dp = (maxele+1)*[0]
        print(dp)
        for i in range(len(nums)):
            dp[nums[i]]+=nums[i]
        
        # now similar to house robber
        skip = 0 
        take = 0 
        for i in range(len(dp)):
            temp = skip
            skip = max(take,skip)
            take = take+dp[i]
        return max(skip,take)
        
        
        """dp_final = [0]*len(dp)
        dp_final[0] = dp[0] 
        dp_final[1] = max(dp[0],dp[1])
        for i in range(2,len(dp)):
            dp[i] = max(dp[i-2]+dp[i],dp[i-1])
        return dp[-1]"""
            
        
        