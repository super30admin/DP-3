class Solution:
    def deleteAndEarn(self, nums) :
        
        l1 = [0 for i in range(max(nums)+1)]
        
        for i in range(len(l1)):
            for j in range(len(nums)):
                if nums[j] == i:
                    l1[i] = l1[i] + nums[j]
        dp = [[0 for j in range(2)] for i in range(len(l1))]
       
        dp[0][0] = 0
        dp[0][1] = l1[0]
        
        for i in range(1,len(dp)):
                dp[i][0] = max(dp[i-1][0], dp[i-1][1])
                dp[i][1] = dp[i-1][0] + l1[i]        
                    
        return max(dp[len(dp)-1][0], dp[len(dp)-1][1])         
        