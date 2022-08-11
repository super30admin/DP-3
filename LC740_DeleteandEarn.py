
"""
TC = O(n)
SC = O(1)
"""
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        temp = [0]*(max(nums)+1)
 
        for i in range(len(nums)):
            temp[nums[i]]+=nums[i]
            
        prev = temp[0]
        curr = max(temp[0], temp[1])
        

        for i in range(2, len(temp)):
            n = curr
            curr=max(prev+temp[i],n)
            prev = n
            
        return curr