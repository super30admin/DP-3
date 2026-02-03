class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:

        max_value=max(nums)
        map={}
        for num in nums:
            
            map[num]=map.get(num,0)+num
        
        dp=[0]*(max_value+1)
        dp[1]=map.get(1,0)

        for i in range(2,max_value+1):

            dp[i]=max(dp[i-1],dp[i-2]+map.get(i,0))
        
        return dp[max_value]
             
