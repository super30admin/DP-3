class Solution:
    def rob(self, nums: List[int]) -> int:
        l=len(nums)
        
        if l==0:
            return 0
        
        t=[[0 for _ in range(2)]for _ in range(l)]
        t[0][1]=nums[0]
        
        for i in range(1,l):
            t[i][0]=max(t[i-1][0],t[i-1][1])
            t[i][1]=t[i-1][0]+nums[i]
            
        return max(t[l-1][0],t[l-1][1])
        