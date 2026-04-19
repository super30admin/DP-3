# O(n) time, O(n) space
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        if not nums:
            return 0
        
        maxVal = max(nums)
        t = [0]*(maxVal+1)
        
        for num in nums:
            t[num]+=num
 
        for i in range(2,len(t)):
            t[i]=max(t[i-1],t[i]+t[i-2])
        
        return t[-1]