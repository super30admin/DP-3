class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        p=max(nums)
        
        l=[0 for _ in range(p+1)]
        
        for i in nums:
            l[i]+=i
            
            
        skip=0
        take=l[0]
        
        for i in range(1,len(l)):
            temp=skip
            skip=max(skip,take)
            take=temp+l[i]
            
        return max(skip,take)
            
        