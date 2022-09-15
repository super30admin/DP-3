class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        n=len(nums)
        tot=0
        if n==1:
            return nums[0]
        
        freq=[0] * (max(nums)+1)
        #store freq of each
        for i in nums:
            freq[i] += i
            
        dp=[0] * len(freq)
        dp[1]=freq[1]
        for i in range(2,len(freq)):
            dp[i]=max(freq[i]+dp[i-2], dp[i-1])
        return dp[len(freq)-1]
            