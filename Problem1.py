class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
                
        if nums == None or len(nums) ==0:
            return 0        
        value = self.getMax(nums)
        modifiedArray = [0 for _ in range(value+1)]

        for num in nums:
            modifiedArray[num] += num
                
        c = dc = 0        
        for num in modifiedArray:
            temp = dc     
            dc = max(c,dc)
            c = num+temp
        
        return max(c,dc)
    
    def getMax(self,nums):
        max = float('-inf')
        
        for num in nums:
            if num > max:
                max = num
        return max
#Time Complexity = O(n)
#Space Complexity = O(n)