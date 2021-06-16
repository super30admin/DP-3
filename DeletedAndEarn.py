# TC: O(max(max(nums),len(nums))) since we are iterating over a the new array that we form to calculate the maximum gain and also on the original input array for populating the new array.
# SC: O(max(nums)) since we create a new array to calculate the maximum points we can earn.

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums: 
            return 0
        
        arr = [0]*(max(nums) + 1)
        for i in nums: 
            arr[i] += i
            
        skip = 0
        take = 0
        for i in arr: 
            temp = skip
            skip = max(skip, take)
            take = temp + i
        
        return max(skip,take)
