from pip import List
#Time Complexity = O(n)
#Space Complexity = O(n)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if(len(nums)==0):
            return 0
        max_value = max(nums)
        list1 = [0] * (max_value+1)
        for i in nums:
            list1[i] = list1[i] + i
        temp = 0
        first = 0
        next = 0
        for i in range(len(list1)):
            first = max(temp,next)
            next = list1[i] + temp
            temp = first
        return max(first,next)
        
        
        