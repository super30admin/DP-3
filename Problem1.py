class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        points = defaultdict(int)
        curr = max(nums)
        for i in nums:
            
            points[i]+=i
            
                
        dp= [0]* (curr+1)
        dp[1]= points[1]
        
        
        for i in range(2, len(dp)):
            dp[i]= max(dp[i-1], dp[i-2]+ points[i])
            
        return dp[-1]
