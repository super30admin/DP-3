# Time Complexity : O(n)  
# Space complexity : O(n) : for freqValues Hashmap

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxLength = 0
        
        for i in range(len(nums)):
            if maxLength < nums[i]:
                maxLength = nums[i]
        # print(maxLength)
        
        freqValues = [0] * (maxLength+1)
        # print(freqValues)
        
        for i in range(len(nums)):
            freqValues[nums[i]] = freqValues[nums[i]] + nums[i]
        
        print(freqValues)
        skip = 0
        take = 0
        
        for i in range(maxLength+1):
            temp = skip
            skip =  max(skip, take)
            take = freqValues[i] + temp
        
        return max(skip, take)