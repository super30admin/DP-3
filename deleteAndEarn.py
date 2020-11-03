class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return 0
        
        m = 0
        
        for i in nums:
            m = max(m,i)
            
        arr = [0]*(m+1)
        
        for i in nums:
            arr[i] += i
        
        dp = [[0 for j in range(2)] for i in range(len(arr))]
        
        
        for i in range(1,len(arr)):
            dp[i][0] = max(dp[i-1][0],dp[i-1][1])
            dp[i][1] = dp[i-1][0] + arr[i]
            
        return max(dp[len(dp)-1][0],dp[len(dp)-1][1])
    