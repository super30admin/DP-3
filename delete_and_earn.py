class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        #Initializing the dp array
        dp = [0] *10001

        for num in nums:
            dp[num] += num

        dp_i = dp[0]
        dp_i_1 = 0

        for i in range(1,len(dp)):
            dp_i_1, dp_i_2 = dp_i, dp_i_1
            dp_i = max(dp[i]+dp_i_2,dp_i_1)
        
        return dp_i

#