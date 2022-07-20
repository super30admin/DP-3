class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if(len(nums)== 0):
            return 0
        mx = max(nums)
        
        dp =[0] * (mx + 1)
         
        for num in nums:
            dp[num] = dp[num] + num
        
        skip = 0
        take = dp[0]
        
        for i in range(1,mx + 1):
            temp = skip
            skip = max(skip,take)
            take = temp + dp[i]
            
        return max(skip,take)