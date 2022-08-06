class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        arr = [0]*(max(nums)+1)
        for i in range(len(nums)):
            arr[nums[i]] += nums[i]
            
        curr = arr[0]
        prev = 0
        for i in range(1,len(arr)):
            temp = curr
            curr = max(curr, prev+arr[i])
            prev = temp
        
        return curr