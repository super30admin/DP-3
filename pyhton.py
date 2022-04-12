from abc import update_abstractmethods


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums==None or len(nums)==0: return 0
        max1=-99999
        for num in nums:
            max1=max(max1,num)
        dp=[0 for x in range(max1+1)]
        for num in nums:
            dp[num]=dp[num]+num
            
        skip=0
        take=0
        for i in range(1,len(dp)):
            temp=skip
            skip=max(skip,take)
            take=temp+dp[i]
            
        return max(skip,take)
        
        //update