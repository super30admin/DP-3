'''
space - O(1)
time - O(max(n))
'''
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        freq = [0]*(max(nums)+1) # O(max(nums))
        for n in nums:
            freq[n]+=n
        
        return self.earndp(freq)
        
    def earndp(self, freq): # same as 198. house robber
        p2,p1 = freq[0],freq[1]
        for i in range(2,len(freq)):
            curr = max(freq[i]+p2, p1)
            p2=p1
            p1=curr
        return p1

