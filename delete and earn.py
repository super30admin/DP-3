# Time Complexity --> O(n) where n is the max value available in the input list
# Space Complexity --> O(n)
# Approach --> creating an array where the indices would represent the number available in nums list. The values would be the sum of all its occurrences
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        arr = [0]*(max(nums)+1)
        for i in range(len(nums)):
            arr[nums[i]] = arr[nums[i]]+nums[i]

        
        for i in range(2, len(arr)):
            arr[i] = max(arr[i-1], arr[i]+arr[i-2])
        return arr[-1]
        
