# Time Complexity: O(n) where n is the max element in the array
# Space Complexity: O(n) where n is the max element in the array
# Ran on Leetcode: Yes

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not len(nums):
            return 0
        m = max(nums)
        arr = [0] * (m + 1)
        for elem in nums:
            arr[elem] += elem
        skip = 0
        take = arr[0]
        for i in range(1, len(arr)):
            temp = skip
            skip = max(skip, take)
            take = temp + arr[i]
        return max(skip, take)
            
        