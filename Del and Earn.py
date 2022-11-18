from collections import defaultdict
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums)==0 or nums==None:
            return 0
        max_1=max(nums)
        dp=[0 for i in range(max_1+1)]
        for i in range(len(nums)):
            ind=nums[i]
            dp[ind]=dp[ind]+nums[i]
        skip=0
        take=dp[0]
        for j in range(1,len(dp)):
            temp=skip
            skip=max(skip,take)
            take=temp+dp[j]
        return max(take,skip)

#Time complexity O(n+max(nums))
#Space Complexity O(n)
        
          


















        # hmp = defaultdict(int)
        # maxx = 0
        # score = 0
        # for i in nums:
        #     if i not in hmp:
        #         if i 
        #         if i > maxx:
        #             maxx = i
        #         hmp[i] = 1
        #     else:
        #         hmp[i] = hmp[i] + 1 
        # if maxx in nums: 
        #     score = score + hmp[maxx]    
        # if maxx - 1 in nums: 
        #     score = score + hmp[maxx - 1] 
        # if maxx + 1 in nums: 
        #     score = score + hmp[maxx + 1]            
        # print(hmp, maxx)
        # return score
        
