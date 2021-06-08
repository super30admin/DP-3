from typing import List

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        maximum = 0
        for num in nums:
            maximum = max(num, maximum)
        arr = [0] * (maximum + 1)
        for i in range(len(nums)):
            index = nums[i]
            arr[index] += nums[i]
        skip = 0
        take = arr[0]
        for i in range(len(arr)):
            prevSkip = skip
            skip = max(skip, take)
            take = prevSkip + arr[i]
        return max(skip, take)

obj = Solution()
print(obj.deleteAndEarn([3,4,2]))
print(obj.deleteAndEarn([2,2,3,3,3,4]))

# Time Complexity : maximum of O(n) and O(max(nums)) where n is number of elements in nums
# Space Complexity : O(1)